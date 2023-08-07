<!-- transform.xsl -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <body>
    <xsl:apply-templates select="employees/employees"></xsl:apply-templates>
  </body>
</xsl:template>

   <!-- Transformation for each employee element -->
  <xsl:template match="employees"> <!-- El nombre de aqui debe matchar con el mismo objeto en el xml original -->
    <employee>
      <id>
        <xsl:value-of select="id"></xsl:value-of>
      </id>
      <name>
        <xsl:value-of select="concat('wellcome ', name)"/>
      </name>
      <house>
        <xsl:apply-templates select="address"></xsl:apply-templates>
      </house>
    </employee>
  </xsl:template>

  <xsl:template match="address" name="address">
      <xsl:value-of select="name"/>
  </xsl:template>



</xsl:stylesheet>