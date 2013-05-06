<#--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->
<#escape x as x?xml>
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
<fo:layout-master-set>
		<fo:simple-page-master master-name="all-pages" page-width="8.27in" page-height="11.69in">
			<fo:region-body region-name="xsl-region-body" margin-left="0.7in" margin-right="0.7in" margin-top="0.7in" margin-bottom="0.7in" column-gap="0.25in" />
			<fo:region-before region-name="xsl-region-before" extent="0.7in" display-align="after" padding-left="0.7in" padding-right="0.7in"/>
			<fo:region-after region-name="xsl-region-after" extent="0.7in" padding-left="0.7in" padding-right="0.7in"/>
		</fo:simple-page-master>
		<fo:page-sequence-master master-name="default-sequence">
			<fo:repeatable-page-master-reference master-reference="all-pages" />
		</fo:page-sequence-master>
	</fo:layout-master-set>
	<fo:page-sequence master-reference="default-sequence">
		<fo:static-content flow-name="xsl-region-before" >
			<fo:block>&#x00A0;</fo:block>
		</fo:static-content>
		<fo:static-content flow-name="xsl-region-after" >
			<fo:block>&#x00A0;</fo:block>
		</fo:static-content>
		<fo:flow flow-name="xsl-region-body" >
			<fo:block><fo:inline font-family="Angsana New">&#x00A0;<fo:block/>&#x00A0;</fo:inline><fo:inline font-family="Angsana New">&#x00A0;</fo:inline></fo:block>
			<fo:block><fo:inline font-family="Angsana New">&#x00A0;</fo:inline></fo:block>
			<fo:block><fo:block xml:lang="en-US" text-align="right" margin-top="0.04in" font-size="large"> <fo:inline font-family="Angsana New"> Stock Move </fo:inline></fo:block><fo:block xml:lang="en-US" text-align="right" margin-top="0.04in" font-size="large">
</fo:block>
<fo:block xml:lang="en-US" text-align="right" margin-top="0.04in" font-size="large">  <fo:block>
                <fo:instream-foreign-object>
                    <barcode:barcode xmlns:barcode="http://barcode4j.krysalis.org/ns"
                            message="1DO-12345678">
                        <barcode:code39>
                            <barcode:height>8mm</barcode:height>
                        </barcode:code39>
                    </barcode:barcode>
                </fo:instream-foreign-object>
            </fo:block></fo:block><fo:block xml:lang="en-US" text-align="right" margin-top="0.04in">


</fo:block><fo:block xml:lang="en-US">
<fo:table     border-collapse="separate" border-spacing="0px" border="1px" display-align="center" inline-progression-dimension="680px" width="auto" table-layout="fixed" margin-right="-0.003in">
<fo:table-column column-width="proportional-column-width(9.649)" column-number="1"/>
<fo:table-column column-width="proportional-column-width(21.443)" column-number="2"/>
<fo:table-column column-width="proportional-column-width(55.916)" column-number="3"/>


<fo:table-column column-width="proportional-column-width(12.992)" column-number="4"/>
<fo:table-body text-align="start" text-align-last="relative">
<fo:table-row display-align="before">
<fo:table-cell border="1px" padding="4px" background-color="#E6E6E6" border-top="1px solid #808080" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="none" padding-top="0.04in" padding-bottom="0.04in" padding-left="0.04in">
<fo:block text-align="center" margin-top="0.04in" font-size="9pt"><fo:inline xml:lang="en-US" text-align="right" margin-top="0.04in" font-size="large" font-family="Angsana New">Number</fo:inline><fo:inline font-family="Angsana New"></fo:inline></fo:block>
</fo:table-cell>
<fo:table-cell border="1px" padding="4px" background-color="#E6E6E6" border-top="1px solid #808080" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="none" padding-top="0.04in" padding-bottom="0.04in" padding-left="0.04in">
<fo:block text-align="center" margin-top="0.04in"><fo:inline  font-size="9pt">Product ID</fo:inline></fo:block>
</fo:table-cell>
<fo:table-cell border="1px" padding="4px" background-color="#E6E6E6" border-top="1px solid #808080" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="none" padding-top="0.04in" padding-bottom="0.04in" padding-left="0.04in">
<fo:block text-align="center" margin-top="0.04in" font-size="9pt">Product Name<fo:inline font-family="Angsana New"></fo:inline></fo:block>
</fo:table-cell>


<fo:table-cell border="1px solid #808080" padding="0.04in" background-color="#E6E6E6">
<fo:block text-align="right" margin-top="0.04in" font-size="9pt"><fo:inline font-family="Angsana New" font-size="12pt">QTY</fo:inline></fo:block>
</fo:table-cell>
</fo:table-row>
 <#list data as d>
<fo:table-row>
<fo:table-cell border="1px" padding="4px" display-align="after" border-top="none" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="none" padding-bottom="0.04in" padding-left="0.04in">
<fo:block text-align="center" font-size="9pt">

<fo:inline font-family="Angsana New">${d.number}

</fo:inline></fo:block>
</fo:table-cell>
<fo:table-cell border="1px" padding="4px" display-align="after" border-top="none" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="none" padding-bottom="0.04in" padding-left="0.04in">
<fo:block text-align="left" font-size="9pt">

<fo:inline font-family="Angsana New">${d.productcode}

</fo:inline></fo:block>
</fo:table-cell>
<fo:table-cell border="1px" padding="4px" display-align="before" border-top="none" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="none" padding-bottom="0.04in" padding-left="0.04in">
<fo:block text-align="left" font-size="9pt">

<fo:inline font-family="Angsana New">${d.productname}

</fo:inline></fo:block>
</fo:table-cell>


<fo:table-cell border="1px" padding="4px" display-align="after" border-top="none" border-bottom="1px solid #808080" border-left="1px solid #808080" border-right="1px solid #808080" padding-bottom="0.04in" padding-left="0.04in" padding-right="0.04in">
<fo:block text-align="right" font-size="9pt">

<fo:inline font-family="Angsana New">${d.unit}

</fo:inline></fo:block>
</fo:table-cell>
</fo:table-row>
</#list>



</fo:table-body>
</fo:table>
</fo:block><fo:block xml:lang="en-US" text-align="left" margin-top="0.04in">


</fo:block><fo:block xml:lang="en-US" margin-top="0.04in" text-decoration="underline"><fo:inline font-family="Angsana New"></fo:inline></fo:block><fo:block xml:lang="en-US" text-align="left" margin-top="0.04in">


</fo:block><fo:block xml:lang="en-US" text-align="left" margin-top="0.04in">


</fo:block><fo:block xml:lang="en-US"><fo:table border-collapse="separate" border-spacing="0px" border="1px" display-align="center" inline-progression-dimension="100%"><fo:table-column column-width="proportional-column-width(85)"/><fo:table-column column-width="proportional-column-width(85)"/><fo:table-column column-width="proportional-column-width(85)"/><fo:table-body text-align="start" text-align-last="relative"><fo:table-row display-align="before"><fo:table-cell border="1px" padding="4px" border-top="none" border-bottom="none" border-left="1.00pt dotted #808080" border-right="none" padding-left="0.04in"><fo:block margin-top="0.04in" font-size="9pt"><fo:inline font-family="Angsana New">Receipt by :</fo:inline></fo:block><fo:block margin-top="0.04in" font-size="9pt">

</fo:block><fo:block margin-top="0.04in" font-size="9pt">
</fo:block></fo:table-cell><fo:table-cell border="1px" padding="4px" border-top="none" border-bottom="none" border-left="1.00pt dotted #808080" border-right="none" padding-left="0.04in"><fo:block margin-top="0.04in" font-size="9pt"><fo:inline font-family="Angsana New">Note :</fo:inline></fo:block></fo:table-cell><fo:table-cell border="1px" padding="4px" border-top="none" border-bottom="none" border-left="1.00pt dotted #808080" border-right="none" padding-left="0.04in"><fo:block margin-top="0.04in" font-size="9pt"><fo:inline font-family="Angsana New">Location :</fo:inline></fo:block></fo:table-cell></fo:table-row></fo:table-body></fo:table>
</fo:block><fo:block xml:lang="en-US" text-align="left" margin-top="0.04in">


</fo:block>&#x00A0;</fo:block>
		</fo:flow>
	</fo:page-sequence>
</fo:root>
</#escape>
