<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="${path}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${path}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${path}/dist/js/adminlte.min.js"></script>
<!-- HandleBars JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>

<script src="${path}/plugins/ekko-lightbox/ekko-lightbox.js"></script>
<!-- AdminLTE App -->
<script src="${path}/dist/js/pages/dashboard3.js"></script>
<!-- OPTIONAL SCRIPTS -->
<script src="${path}/plugins/chart.js/Chart.min.js"></script>
<script src="${path}/plugins/chart.js/utils.js"></script>
<!-- chartjs -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript">
'use strict';
window.chartColors = {
			red: 'rgb(255, 99, 132)',
			orange: 'rgb(255, 159, 64)',
			yellow: 'rgb(255, 205, 86)',
			green: 'rgb(75, 192, 192)',
			blue: 'rgb(54, 162, 235)',
			purple: 'rgb(153, 102, 255)',
			grey: 'rgb(201, 203, 207)'
		};

		(function(global) {
			var MONTHS = [
				'January',
				'February',
				'March',
				'April',
				'May',
				'June',
				'July',
				'August',
				'September',
				'October',
				'November',
				'December'
			];

			var COLORS = [
				'#4dc9f6',
				'#f67019',
				'#f53794',
				'#537bc4',
				'#acc236',
				'#166a8f',
				'#00a950',
				'#58595b',
				'#8549ba'
			];

			var Samples = global.Samples || (global.Samples = {});
			var Color = Chart.helpers.color;

			function applyDefaultNumbers(config) {
				var cfg = config || {};
				cfg.min = cfg.min || 0;
				cfg.max = cfg.max || 1;
				cfg.from = cfg.from || [];
				cfg.count = cfg.count || 8;
				cfg.decimals = cfg.decimals || 8;
				cfg.continuity = cfg.continuity || 1;

				return cfg;
			}

			Samples.utils = {
				// Adapted from http://indiegamr.com/generate-repeatable-random-numbers-in-js/
				srand: function(seed) {
					this._seed = seed;
				},

				rand: function(min, max) {
					var seed = this._seed;
					min = min === undefined ? 0 : min;
					max = max === undefined ? 1 : max;
					this._seed = (seed * 9301 + 49297) % 233280;
					return min + (this._seed / 233280) * (max - min);
				},

				numbers: function(config) {
					var cfg = applyDefaultNumbers(config);
					var dfactor = Math.pow(10, cfg.decimals) || 0;
					var data = [];
					var i, value;

					for (i = 0; i < cfg.count; ++i) {
						value = (cfg.from[i] || 0) + this.rand(cfg.min, cfg.max);
						if (this.rand() <= cfg.continuity) {
							data.push(Math.round(dfactor * value) / dfactor);
						} else {
							data.push(null);
						}
					}

					return data;
				},

				labels: function(config) {
					var cfg = config || {};
					var min = cfg.min || 0;
					var max = cfg.max || 100;
					var count = cfg.count || 8;
					var step = (max - min) / count;
					var decimals = cfg.decimals || 8;
					var dfactor = Math.pow(10, decimals) || 0;
					var prefix = cfg.prefix || '';
					var values = [];
					var i;

					for (i = min; i < max; i += step) {
						values.push(prefix + Math.round(dfactor * i) / dfactor);
					}

					return values;
				},

				months: function(config) {
					var cfg = config || {};
					var count = cfg.count || 12;
					var section = cfg.section;
					var values = [];
					var i, value;

					for (i = 0; i < count; ++i) {
						value = MONTHS[Math.ceil(i) % 12];
						values.push(value.substring(0, section));
					}

					return values;
				},

				color: function(index) {
					return COLORS[index % COLORS.length];
				},

				transparentize: function(color, opacity) {
					var alpha = opacity === undefined ? 0.5 : 1 - opacity;
					return Color(color).alpha(alpha).rgbString();
				}
			};

			// DEPRECATED
			window.randomScalingFactor = function() {
				return Math.round(Samples.utils.rand(-100, 100));
			};

			// INITIALIZATION

			Samples.utils.srand(Date.now());

			// Google Analytics
			/* eslint-disable */
			if (document.location.hostname.match(/^(www\.)?chartjs\.org$/)) {
				(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
				(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
				m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
				})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
				ga('create', 'UA-28909194-3', 'auto');
				ga('send', 'pageview');
			}
			/* eslint-enable */

		}(this));
</script>
<script>
  /*  const labels = [
    '1st',
    '10th',
    '15th',
    '20th',
    '25th',
    '30th',
  ];

  const data = {
    labels: labels,
    datasets: [{
      label: '1월 코스피 지수',
      backgroundColor: 'rgb(0, 123, 255)',
      borderColor: 'rgb(0, 123, 255)',
      data: [2860.00, 2920.00,2980.00 , 2960.00, 2980.00, 3010.00, 3000.00],
    }]
  }; */

  const config = {
		  type: 'line',
		  data: {
		    datasets: [{
		      borderColor: window.chartColors.red,
		      borderWidth: 1,
		      radius: 0,
		      data: data,
		    },
		    {
		      borderColor: window.chartColors.blue,
		      borderWidth: 1,
		      radius: 0,
		      data: data2,
		    }]
		  },
		  options: {
		    animation,
		    interaction: {
		      intersect: false
		    },
		    plugins: {
		      legend: false,
		      title: {
		        display: true,
		        text: () => easing.name
		      }
		    },
		    scales: {
		      x: {
		        type: 'linear'
		      }
		    }
		  }
		}
  let easing = helpers.easingEffects.easeOutQuad;
  let restart = false;
  const totalDuration = 5000;
  const duration = (ctx) => easing(ctx.index / data.length) * totalDuration / data.length;
  const delay = (ctx) => easing(ctx.index / data.length) * totalDuration;
  const previousY = (ctx) => ctx.index === 0 ? ctx.chart.scales.y.getPixelForValue(100) : ctx.chart.getDatasetMeta(ctx.datasetIndex).data[ctx.index - 1].getProps(['y'], true).y;
  const animation = {
    x: {
      type: 'number',
      easing: 'linear',
      duration: duration,
      from: NaN, // the point is initially skipped
      delay(ctx) {
        if (ctx.type !== 'data' || ctx.xStarted) {
          return 0;
        }
        ctx.xStarted = true;
        return delay(ctx);
      }
    },
    y: {
      type: 'number',
      easing: 'linear',
      duration: duration,
      from: previousY,
      delay(ctx) {
        if (ctx.type !== 'data' || ctx.yStarted) {
          return 0;
        }
        ctx.yStarted = true;
        return delay(ctx);
      }
    }
  };
  const data = [];
  const data2 = [];
  let prev = 100;
  let prev2 = 80;
  for (let i = 0; i < 1000; i++) {
    prev += 5 - Math.random() * 10;
    data.push({x: i, y: prev});
    prev2 += 5 - Math.random() * 10;
    data2.push({x: i, y: prev2});
  }
  function restartAnims(chart) {
	  chart.stop();
	  const meta0 = chart.getDatasetMeta(0);
	  const meta1 = chart.getDatasetMeta(1);
	  for (let i = 0; i < data.length; i++) {
	    const ctx0 = meta0.controller.getContext(i);
	    const ctx1 = meta1.controller.getContext(i);
	    ctx0.xStarted = ctx0.yStarted = false;
	    ctx1.xStarted = ctx1.yStarted = false;
	  }
	  chart.update();
	}

	const actions = [
	  {
	    name: 'easeOutQuad',
	    handler(chart) {
	      easing = helpers.easingEffects.easeOutQuad;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeOutCubic',
	    handler(chart) {
	      easing = helpers.easingEffects.easeOutCubic;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeOutQuart',
	    handler(chart) {
	      easing = helpers.easingEffects.easeOutQuart;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeOutQuint',
	    handler(chart) {
	      easing = helpers.easingEffects.easeOutQuint;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeInQuad',
	    handler(chart) {
	      easing = helpers.easingEffects.easeInQuad;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeInCubic',
	    handler(chart) {
	      easing = helpers.easingEffects.easeInCubic;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeInQuart',
	    handler(chart) {
	      easing = helpers.easingEffects.easeInQuart;
	      restartAnims(chart);
	    }
	  },
	  {
	    name: 'easeInQuint',
	    handler(chart) {
	      easing = helpers.easingEffects.easeInQuint;
	      restartAnims(chart);
	    }
	  },
	];
</script>
<script>
  const myChart = new Chart(
    document.getElementById('myChart'),
    config
  );
</script>
 