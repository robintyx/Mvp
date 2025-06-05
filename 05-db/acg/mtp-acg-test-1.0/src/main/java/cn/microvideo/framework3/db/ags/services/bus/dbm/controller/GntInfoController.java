package cn.microvideo.framework3.db.ags.services.bus.dbm.controller;

import cn.microvideo.framework3.core.initialization.http.MicroviceoHttpRsp;
import cn.microvideo.framework3.core.initialization.result.MicrovideoListPageResult;
import cn.microvideo.framework3.core.scauser.handler.ScgUserHandlers;
import cn.microvideo.framework3.core.scauser.user.ScgUser;
import cn.microvideo.framework3.db.ags.services.bus.dbm.entity.GntInfo;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoQueryParam;
import cn.microvideo.framework3.db.ags.services.bus.dbm.param.GntInfoFormParam;
import cn.microvideo.framework3.db.ags.services.bus.dbm.service.AbstractGntInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 感动科技.
 * 企业信息表-通用服务.
 * @author microvideo
 * @since Sat Apr 13 18:12:32 CST 2024
 */
@Schema(name = "企业信息表接口")
@Tag(name = "企业信息表接口")
@RestController
@Slf4j
@RequestMapping("/ags/gntinfo")
public class GntInfoController extends ScgUserHandlers {
    @Override
    public Logger getChaeLog() {
        return log;
    }

    @Resource
    private AbstractGntInfoService service;


    @Operation(summary = "【企业信息表】列表查询", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "查询参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/list", method={RequestMethod.POST})
    public MicroviceoHttpRsp<MicrovideoListPageResult<GntInfo>> list(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        MicrovideoListPageResult<GntInfo> result=new MicrovideoListPageResult<>();
        result.setList(service.query(param));
        return success("列表查询完成", result);
    }

    @Operation(summary = "【企业信息表】分页查询", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "查询参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/page/list", method={RequestMethod.POST})
    public MicroviceoHttpRsp<MicrovideoListPageResult<GntInfo>> pagelist(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        param.setPage(getPage(param.getPage()));
        MicrovideoListPageResult<GntInfo> result=new MicrovideoListPageResult<>();
        result.setList(service.query(param, param.getPage()));
        result.setPage(param.getPage());
        return success("分页查询完成", result);
    }

    @Operation(summary = "【企业信息表】根据id查询", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "查询参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/get/id", method={RequestMethod.POST})
    public MicroviceoHttpRsp<GntInfo> findId(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        return success("根据id查询完成", service.findById(param.getId()));
    }

    @Operation(summary = "【企业信息表】添加", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "添加参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public MicroviceoHttpRsp<String> add(@Valid @RequestBody GntInfoFormParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        service.addForm(param);
        return success("添加完成", param.getId());
    }

    @Operation(summary = "【企业信息表】根据id更新", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "修改参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/edit/id", method={RequestMethod.POST})
    public MicroviceoHttpRsp<String> updateId(@Valid @RequestBody GntInfoFormParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        service.updateForm(param);
        return success("根据id更新完成", param.getId());
    }

    @Operation(summary = "【企业信息表】根据id删除", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "删除参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/del/id", method={RequestMethod.POST})
    public MicroviceoHttpRsp<String> delId(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        service.deleteById(param.getId());
        return success("根据id删除完成", param.getId());
    }

    @Operation(summary = "【企业信息表】根据ids删除", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "删除参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/del/ids", method={RequestMethod.POST})
    public MicroviceoHttpRsp<String> delIds(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        service.batchDelete(param.getIdText());
        return success("删除完成", param.getIdText());
    }

    @Operation(summary = "【企业信息表】根据id逻辑删除", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "删除参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/delflag/id", method={RequestMethod.POST})
    public MicroviceoHttpRsp<String> delFlagId(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        service.deleteFlagById(param.getId(), param.getVersion());
        return success("删除完成", param.getId());
    }

    @Operation(summary = "【企业信息表】根据ids逻辑删除", description = "企业信息表")
    @Parameters({
            @Parameter(name = "param", description = "删除参数", required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "失败"),
            @ApiResponse(responseCode = "403", description = "无权访问"),
            @ApiResponse(responseCode = "406", description = "无权访问")
    })
    @RequestMapping(value="/delflag/ids", method={RequestMethod.POST})
    public MicroviceoHttpRsp<String> delFlagIds(@RequestBody GntInfoQueryParam param, HttpServletRequest request) {
        ScgUser user = getUser(request.getSession(), request);
        service.batchDeleteFlag(param.getIdText());
        return success("删除完成", param.getIdText());
    }
}
