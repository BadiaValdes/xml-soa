<!-- transform.xsl -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

   <!-- Transformation for each employee element -->
  <xsl:template match="employee"> <!-- El nombre de aqui debe matchar con el mismo objeto en el xml original -->
    <employee>
      <name>
        <xsl:value-of select="concat(name, '++', id)"/>
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