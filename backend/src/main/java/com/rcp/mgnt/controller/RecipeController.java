/**
 * 
 */
package com.rcp.mgnt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rcp.mgnt.model.RcpInfoTO;
import com.rcp.mgnt.service.RcpService;

@Controller
@RequestMapping(RecipeController.REQUEST_MAPPING)
public class RecipeController {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(RecipeController.class);

	public static final String REQUEST_MAPPING = "/v0";

	@Autowired
	private RcpService rcpService;

	public RecipeController() {
		super();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public String registerRecipe(@RequestBody @Valid RcpInfoTO rcpInfoTO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return rcpService.save(rcpInfoTO);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public List<RcpInfoTO> getRecipeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return rcpService.get();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public RcpInfoTO getRecipeById(@PathVariable @NotNull String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return rcpService.get(id);
	}

}
