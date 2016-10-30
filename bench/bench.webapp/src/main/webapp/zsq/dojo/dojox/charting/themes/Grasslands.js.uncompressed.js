define("dojox/charting/themes/Grasslands", ["../SimpleTheme", "./common"], function(SimpleTheme, themes){
	// notes: colors generated by moving in 30 degree increments around the hue circle,
	//		at 90% saturation, using a B value of 75 (HSB model).
	themes.Grasslands = new SimpleTheme({
		colors: [
			"#70803a",
			"#dde574",
			"#788062",
			"#b1cc5d",
			"#eff2c2"
		]
	});
	return themes.Grasslands;
});
