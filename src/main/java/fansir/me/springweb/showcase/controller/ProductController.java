package fansir.me.springweb.showcase.controller;

import javax.validation.groups.Default;

import fansir.me.springweb.common.constant.ApplicationConstant;
import fansir.me.springweb.common.controller.AbstractController;
import fansir.me.springweb.common.converter.ConverterService;
import fansir.me.springweb.common.dto.ResultDto;
import fansir.me.springweb.common.dto.ResultDtoFactory;
import fansir.me.springweb.common.dto.annotation.OnValid;
import fansir.me.springweb.common.dto.widget.DataTablesResponseDto;
import fansir.me.springweb.common.enumeration.EErrorCode;
import fansir.me.springweb.common.exception.BizServiceException;
import fansir.me.springweb.common.util.EnumHelper;
import fansir.me.springweb.common.util.web.WebUtil;
import fansir.me.springweb.showcase.domain.Product;
import fansir.me.springweb.showcase.dto.ProductDto;
import fansir.me.springweb.showcase.dto.upstream.ProductSearchDto;
import fansir.me.springweb.showcase.enumeration.EProductCagetory;
import fansir.me.springweb.showcase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class Name: ProductController Description: TODO
 * 
 *
 */
@Controller
public class ProductController extends AbstractController {

    @Autowired
    private transient ProductService productService;

    
    /**
    * Description: render home page
    *
    * @param model
    * @return
    */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EProductCagetory.class));
        return "product/product_list";
    }

    
    /**
    * Description: search product list on the home page
    *
    * @param request
    * @return
    */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public DataTablesResponseDto<Product> search(@RequestBody ProductSearchDto request) {
        DataTablesResponseDto<Product> resp = productService.searchProduct(request);
        resp.setEcho(request.getEcho());
        return resp;
    }

    
    /**
    * Description: render add-product page
    *
    * @param model
    * @return
    */
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EProductCagetory.class));
        return "product/product_add";
    }

    
    /**
    * Description: add a product
    *
    * @param dto
    * @return
    */
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    @ResponseBody
    public ResultDto add(@RequestBody @OnValid(value = {ProductDto.CreateProduct.class, Default.class}) ProductDto dto) {
        Product entity = ConverterService.convert(dto, Product.class);
        productService.saveProduct(entity);
        return ResultDtoFactory.toRedirect(WebUtil.getFullUrlBasedOn(ApplicationConstant.GLOBAL_CONTEXT + "/products"));
    }

    
    /**
    * Description: render the detail page of a product
    *
    * @param id
    * @param model
    * @return
    */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") String id, Model model) {
        Product detail = productService.findProductById(id);
        if (detail == null) {
            throw new BizServiceException(EErrorCode.PRODUCT_NOT_FOUND);
        }
        model.addAttribute("detail", detail);
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EProductCagetory.class));
        return "product/product_edit";
    }
    
    
    /**
    * Description: update a product
    *
    * @param id
    * @param dto
    * @return
    */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto update(@PathVariable(value = "id") String id, @RequestBody @OnValid ProductDto dto) {
        Product entity = ConverterService.convert(dto, Product.class);
        entity.setId(id);
        productService.saveProduct(entity);
        return ResultDtoFactory.toAck("successfully updated!");
    }

    
    /**
    * Description: delete a product
    *
    * @param id
    * @return
    */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDto delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return ResultDtoFactory.toAck("successfully deleted!");
    }

}
