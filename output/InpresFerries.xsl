<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="no" encoding="utf-8"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>InpresFerries_OUT</title>
			</head>
			<body>
				<h1>Ferry '<xsl:value-of select="Ferry/@name"/>'</h1>
					<h2>Informations</h2>
						<ul>
							<li>Nom du voyageur : <i><xsl:value-of select="Ferry/@voyageur"/></i></li>
						</ul>
					<h2>Monnaie</h2>
						<h3>Cours</h3>
							<xsl:for-each select="Ferry/Monnaie/Cours">
							<ul>
								<li>Pays de provenance : <i><xsl:value-of select="@paysFrom"/></i></li>
								<li>Pays de destination : <i><xsl:value-of select="@paysTo"/></i></li>
								<li>Unité monétaire du pays de provenance : <i><xsl:value-of select="@uniteMonetairePaysFrom"/></i></li>
								<li>Unité monétaire du pays de destination : <i><xsl:value-of select="@uniteMonetairePaysTo"/></i></li>
								<li>Facteur de conversion : <i><xsl:value-of select="@facteurConversion"/></i></li>
							</ul>
							</xsl:for-each>
					<h2>Météo</h2>
						<h3>Situation</h3>
							<xsl:for-each select="Ferry/Meteo/Situation">
							<ul>
								<li>Région : <i><xsl:value-of select="@region"/></i></li>
								<li>Pays : <i><xsl:value-of select="@pays"/></i></li>
								<li>Dates :
									<ul>
										<xsl:for-each select="Dates/Jour">
										<li>Jour : <i><xsl:value-of select="@value"/></i></li>
										<ul>
											<li>Température : <i><xsl:value-of select="@temperature"/></i></li>
											<li>Force du vent : <i><xsl:value-of select="@forceVent"/></i></li>
											<li>Type de vent : <i><xsl:value-of select="@typeTemps"/></i></li>
										</ul>
										</xsl:for-each>
									</ul>
								</li>
							</ul>
							</xsl:for-each>
					<h2>Freetax</h2>
						<h3>Alcools</h3>
							<xsl:for-each select="Ferry/Freetax/Alcools">
							<ul>
								<li>Nom : <i><xsl:value-of select="@nom"/></i></li>
								<li>Marque : <i><xsl:value-of select="@marque"/></i></li>
								<li>Quantité : <i><xsl:value-of select="@quantite"/></i></li>
								<li>Prix : <i><xsl:value-of select="@prix"/></i></li>
							</ul>
							</xsl:for-each>
						<h3>Parfums</h3>
							<xsl:for-each select="Ferry/Freetax/Parfums">
							<ul>
								<li>Nom : <i><xsl:value-of select="@nom"/></i></li>
								<li>Marque : <i><xsl:value-of select="@marque"/></i></li>
								<li>Quantité : <i><xsl:value-of select="@quantite"/></i></li>
								<li>Prix : <i><xsl:value-of select="@prix"/></i></li>
							</ul>
							</xsl:for-each>
						<h3>Tabacs</h3>
							<xsl:for-each select="Ferry/Freetax/Tabacs">
							<ul>
								<li>Nom : <i><xsl:value-of select="@nom"/></i></li>
								<li>Marque : <i><xsl:value-of select="@marque"/></i></li>
								<li>Quantité : <i><xsl:value-of select="@quantite"/></i></li>
								<li>Prix : <i><xsl:value-of select="@prix"/></i></li>
							</ul>
							</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>