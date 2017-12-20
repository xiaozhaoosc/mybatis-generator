package org.mybatis.generator.codegen.mybatis3;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.ProgressCallback;

import java.util.List;

/**
 * Created by wuwen on 2017/5/9.
 */
public class IntrospectedTableWwImpl extends IntrospectedTable {

    public IntrospectedTableWwImpl(TargetRuntime targetRuntime) {
        super(targetRuntime);
    }

    public void calculateGenerators(List<String> list, ProgressCallback progressCallback) {

    }

    public List<GeneratedJavaFile> getGeneratedJavaFiles() {
        return null;
    }

    public List<GeneratedXmlFile> getGeneratedXmlFiles() {
        return null;
    }

    public boolean isJava5Targeted() {
        return false;
    }

    public int getGenerationSteps() {
        return 0;
    }

    public boolean requiresXMLGenerator() {
        return false;
    }
}
