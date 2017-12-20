package org.mybatis.generator.codegen.mybatis3.javamapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wuwen on 2017/5/16.
 */
public class SelectMethodGenerator extends
        AbstractJavaMapperMethodGenerator {

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
//        FullyQualifiedJavaType returnType = introspectedTable.getRules()
//                .calculateAllFieldsClass();
        FullyQualifiedJavaType returnType = new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getFullyQualifiedTable().getDomainObjectName() + ">");
        method.setReturnType(returnType);
        importedTypes.add(returnType);
        method.setName(introspectedTable.getSelectList());

        FullyQualifiedJavaType parameterType = introspectedTable.getRules()
                .calculateAllFieldsClass();

        importedTypes.add(parameterType);
        method.addParameter(new Parameter(parameterType, "record"));

        // no primary key class - fields are in the base class
        // if more than one PK field, then we need to annotate the
        // parameters
        // for MyBatis3
//        List<IntrospectedColumn> introspectedColumns = introspectedTable
//                .getPrimaryKeyColumns();
//        boolean annotate = introspectedColumns.size() > 1;
//        if (annotate) {
//            importedTypes.add(new FullyQualifiedJavaType(
//                    "org.apache.ibatis.annotations.Param")); //$NON-NLS-1$
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(introspectedTable.getFullyQualifiedTable().getDomainObjectName());
//        sb.append(" ");
//        sb.append()
//        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
//            FullyQualifiedJavaType type = introspectedColumn
//                    .getFullyQualifiedJavaType();
//            importedTypes.add(type);
//            Parameter parameter = new Parameter(type, introspectedColumn
//                    .getJavaProperty());
//            if (annotate) {
//                sb.setLength(0);
//                sb.append("@Param(\""); //$NON-NLS-1$
//                sb.append(introspectedColumn.getJavaProperty());
//                sb.append("\")"); //$NON-NLS-1$
//                parameter.addAnnotation(sb.toString());
//            }
//            method.addParameter(parameter);
//        }


        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(
                method, interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }
}
