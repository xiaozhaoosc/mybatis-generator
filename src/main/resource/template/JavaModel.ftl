<#assign left = "{">
<#assign right = "}">
<#assign test1 = "<!-- 更新数据，为防止误更新特意未设置更新字段，若需要使用请自定义 -->">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${sqlMapper}">
    <resultMap id="BaseResultMap" type="${model}">
    <#list primaryColumns as item>
        <id column="${item.actualColumnName}" jdbcType="${item.jdbcTypeName}" property="${item.javaProperty}"/>
    </#list>
    <#list notPrimaryColumns as item>
        <result column="${item.actualColumnName}" jdbcType="${item.jdbcTypeName}" property="${item.javaProperty}"/>
    </#list>
    </resultMap>

    <sql id="Base_Column_List">
        <#list columns as item>`${item.actualColumnName}`<#sep>,</#list>
    </sql>

    <sql id="Base_ondition_List">
        <where>
            <#list columns as item>
            <if test="${item.javaProperty} != null">
                <#if item_index!=0>and </#if>`${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}
            </if>
            </#list>
        </where>
    </sql>

    <insert id="insert" parameterType="${model}">
        insert into ${tableName} (<include refid="Base_Column_List" />)
        values(<#list columns as item>#${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}<#sep>,</#list>)
    </insert>

    <insert id="insertSelective" parameterType="${model}">
        insert into ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list columns as item>
            <if test="${item.javaProperty} != null">
                `${item.actualColumnName}`,
            </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list columns as item>
            <if test="${item.javaProperty} != null">
                #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right},
            </if>
            </#list>
        </trim>
    </insert>

    <!-- 更新数据，为防止误更新特意未设置更新字段，若需要使用请自定义 -->
    <update id="updateByParams" parameterType="${model}">
        update ${tableName} set
        1=1

        <where>
        <#list notPrimaryColumns as item>
            <if test="${item.javaProperty} != null">
                <#if item_index!=0>and </#if>`${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}
            </if>
        </#list>
        </where>
    </update>

    <update id="updateByPrimaryKey" parameterType="${model}">
        update ${tableName} set
        <#list notPrimaryColumns as item>
            `${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}<#sep>,
        </#list>

        <where>
        <#list primaryColumns as item>
            <if test="${item.javaProperty} != null">
                <#if item_index!=0>and </#if>`${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}
            </if>
        </#list>
        </where>
    </update>

    <update id="updateByPrimaryKeySelective" parameterType="${model}">
        update ${tableName}
        <set>
        <#list notPrimaryColumns as item>
            <if test="${item.javaProperty} != null">
                `${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right},
            </if>
        </#list>
        </set>
        <where>
        <#list primaryColumns as item>
            <if test="${item.javaProperty} != null">
                <#if item_index!=0>and </#if>`${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}
            </if>
        </#list>
        </where>
    </update>

    <delete id="deleteByPrimaryKey" parameterType="map">
        delete from ${tableName}
        <where>
        <#list primaryColumns as item>
            <if test="${item.javaProperty} != null">
                <#if item_index!=0>and </#if>`${item.actualColumnName}` = #${left}${item.javaProperty},jdbcType=${item.jdbcTypeName}${right}
            </if>
        </#list>
        </where>
    </delete>

    <select id="selectOne" parameterType="${model}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <include refid="Base_ondition_List" />
    </select>

    <select id="selectList" parameterType="${model}" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List" />
        from ${tableName}
        <include refid="Base_ondition_List" />
    </select>
</mapper>