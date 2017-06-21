<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="2.0"
>
  <xsl:include href="shared-object-util.xsl"/>

  <xsl:template name="title">
    <xsl:variable name="firstName" select="normalize-space((.//che:individualFirstName)[1])"/>
    <xsl:variable name="lastName" select="normalize-space((.//che:individualLastName)[1])"/>
    <xsl:variable name="email"
                  select="normalize-space((.//gmd:electronicMailAddress/gco:CharacterString[string-length(text()) > 0])[1])"/>
    <xsl:variable name="organization"
                  select="normalize-space((.//gmd:organisationName//gmd:LocalisedCharacterString[string-length(text()) > 0])[1])"/>

    <xsl:variable name="basicTitle" select="concat($firstName, ' ', $lastName, ' ', $email, ' ', $organization)"/>

    <xsl:choose>
      <xsl:when test="string-length(normalize-space($basicTitle)) > 0">
        <xsl:value-of select="$basicTitle"/>
      </xsl:when>
      <xsl:otherwise>No Title information found</xsl:otherwise>
    </xsl:choose>
  </xsl:template>
</xsl:stylesheet>