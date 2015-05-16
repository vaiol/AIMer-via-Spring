package com.kpi.stepanov.rest.controller;

import com.kpi.stepanov.rest.entity.AIM;
import com.kpi.stepanov.rest.service.AIMService;
import com.kpi.stepanov.rest.util.UserUtil;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;


@Secured("ROLE_USER")
@RestController
@RequestMapping("/aim")
public class AIMController {

    @Resource
    private AIMService aimService;

    @RequestMapping(method = RequestMethod.POST)
    public AIM addAIM(@Valid @RequestBody AIM aim) {
        aim.setId(null);
        return aimService.add(aim);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AIM findItem(@PathVariable Integer id) throws Exception{
        AIM aim = aimService.getById(id);
        if (aim == null) {
            throw new IllegalArgumentException();
        }
        if (aim.isCommon()) {
            return aim;
        }
        if( ! UserUtil.compareUsers(aim.getCreator(),(Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            throw new IllegalAccessException();
        }
        return aim;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public AIM updateAIM(@Valid @RequestBody AIM newAim,
                         @PathVariable Integer id) throws Exception {
        AIM aim = aimService.getById(id);
        if (aim == null) {
            throw new IllegalArgumentException();
        }
        if( ! UserUtil.compareUsers(aim.getCreator(),(Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            throw new IllegalAccessException();
        }
        aim.setCommon(newAim.isCommon());
        aim.setCompleted(newAim.isCompleted());
        aim.setDescription(newAim.getDescription());
        aim.setTitle(newAim.getTitle());
        aim.setSteps(newAim.getSteps());
        return aim;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAIM(@PathVariable Integer id) throws IllegalAccessException {
        AIM aim = aimService.getById(id);
        if (aim == null) {
            throw new IllegalArgumentException();
        }
        if( ! UserUtil.compareUsers(aim.getCreator(),(Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            throw new IllegalAccessException();
        }
        aimService.delete(id);
    }
}
