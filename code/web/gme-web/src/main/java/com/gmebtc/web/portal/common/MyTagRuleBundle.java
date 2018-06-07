package com.gmebtc.web.portal.common;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

/*
 * @Author zhou
 * @Date 2018/6/5 14:45
 * @Desc 自定义sitemesh标签
 */
public class MyTagRuleBundle implements TagRuleBundle{


    @Override
    public void install(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
        // 自定义isLogin标签,用于sitemesh修饰页面的时候导入此标签
        state.addRule("isLogin", new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("isLogin"), false));
    }

    @Override
    public void cleanUp(State state, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {

    }
}
