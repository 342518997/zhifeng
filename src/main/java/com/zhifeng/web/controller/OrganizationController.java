package com.zhifeng.web.controller;

import com.zhifeng.service.OrganizationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
