package com.zhifeng.web.controller;

import com.zhifeng.model.Organization;
import com.zhifeng.service.OrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String  index(Model model){
        return "organization/index";
    }
    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    public String tree(Model model){
        model.addAttribute("organizationList",organizationService.findAll());
        return  "organization/tree";
    }
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/maintain",method = RequestMethod.GET)
    public String showMaintainForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("organization",organizationService.findOne(id));
        return "organization/maintain";
    }
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/update",method =RequestMethod.POST)
    public String update(Organization organization, RedirectAttributes redirectAttributes){
        organizationService.updateOrganization(organization);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/organization/success";
    }
    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{id}/appendChild",method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("id") Long id,Model model){
        Organization parent =organizationService.findOne(id);
        model.addAttribute("parent",parent);
        Organization chicd = new Organization();
        chicd.setParentId(id);
        chicd.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("child", chicd);
        model.addAttribute("op", "新增");
        return "organization/appendChild";

    }
    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{id}/appendChild",method = RequestMethod.POST)
    public String update(Organization organization){
        organizationService.createOrganization(organization);
        return "redirect:/organization/success";
    }
    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/{id}/delete",method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        organizationService.deleteOrganization(id);
        return "redirect:/organization/success";
    }
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/move",method = RequestMethod.GET)
    public String move(@PathVariable("id") Long id,Model model){
        Organization source = organizationService.findOne(id);
        model.addAttribute("source", source);
        model.addAttribute("targetList", organizationService.findAllWithExclude(source));

        return "organization/move";
    }
    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.POST)
    public String move(
            @PathVariable("sourceId") Long sourceId,
            @RequestParam("targetId") Long targetId) {
        System.out.println(targetId);
        Organization source = organizationService.findOne(sourceId);
        Organization target = organizationService.findOne(targetId);
        organizationService.move(source, target);
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "organization/success";
    }


}
