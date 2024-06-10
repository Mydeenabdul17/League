<!DOCTYPE html>
<%@page import="com.mydeenAbdul.league.dto.Match"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}
.container {
      width: 80%;
      margin: 20px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    .year-group {
      margin-bottom: 15px;
    }

    .year {
      display: inline-block;
      padding: 8px 15px;
      margin: 5px;
      background-color: #eee;
      border-radius: 5px;
      text-decoration: none;
      color: #333;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .year:hover {
      background-color: #ddd;
    }
.match-details {
	display: flex;
	flex-direction: column;
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.match-header {
	font-size: 2rem;
	font-weight: bold;
	margin-bottom: 10px;
	text-align: center;
}

.match-info {
	margin-bottom: 20px;
}

.match-info p {
	margin-bottom: 5px;
	font-size: 0.9rem;
}

.match-scores {
	font-size: 0.9rem;
}

.match-scores p {
	margin-bottom: 5px;
}

.match-status {
	font-size: 0.9rem;
	margin-top: 20px;
}

.match-card {
	background-color: #f7f7f7;
	padding: 16px;
	border: 1px solid #ddd;
	border-radius: 8px;
	width: 300px;
	margin: 20px;
	/*scroll-snap-align: start;
	text-decoration: none; 
	color: #333;
	display: inline-block;*/
}

.matches {
	display: flex;
	overflow-x: auto;
	-webkit-overflow-scrolling: touch;
	/* For smooth scrolling on mobile devices */
	scroll-snap-type: x mandatory; 
	white-space: nowrap;
}

.match-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 16px;
}

.match-type {
	font-weight: bold;
	font-size: 17px;
}

.match-format {
	font-size: 14px;
	color: #666;
}

.match-detail {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 16px;
}

.team-score {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.team-name {
	font-size: 16px;
	font-weight: bold;
	margin-bottom: 8px;
}

.score {
	font-size: 14px;
	color: #666;
}

.match-result {
	font-size: 16px;
	font-weight: bold;
	color: #333;
	margin-top: 16px;
}

.innings-table, .bowling-table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

.innings-table th, .bowling-table th {
	padding: 8px;
	background-color: #f0f0f0;
	text-align: left;
	border: 1px solid #ddd;
}

.innings-table td, .bowling-table td {
	padding: 8px;
	border: 1px solid #ddd;
}

.fall-of-wickets {
	margin-top: 10px;
	font-size: 14px;
}

.fall-of-wickets a {
	color: #007bff;
	text-decoration: none;
}

.fall-of-wickets a:hover {
	text-decoration: underline;
}

.bowling-table {
	margin-top: 20px;
}

.bowling-table th, .bowling-table td {
	padding: 8px;
	text-align: left;
	border: 1px solid #ddd;
}
</style>
</head>
<body>
	<%List<Match> matches = (List<Match> )request.getAttribute("matches");
	ObjectMapper mapper = new ObjectMapper();
	String matchesJson = mapper.writeValueAsString(matches);%>
	<script type="text/javascript">
function createMatchCards(matches){
	console.log(matches);
    const existingMatches = document.querySelector('.matches');
    if (existingMatches) {
        existingMatches.remove();
    }
    const matchesDiv = document.createElement('div');
    matchesDiv.className = 'matches';

    matches.forEach(matche => {
        const matchCard = document.createElement('div');
        matchCard.className = 'match-card';
        matchCard.addEventListener('click', (event) => {
            event.preventDefault();
            showScoreCard(matche);
        });

        // Create and populate the match header
        const matchHeader = document.createElement('div');
        matchHeader.className = 'match-header';

        const matchType = document.createElement('span');
        matchType.className = 'match-type';
        if(matche!=null){
        	matchType.textContent = matche.team1Score.team.name+" vs "+matche.team2Score.team.name;
           // const matchFormat = document.createElement('span');
           // matchFormat.className = 'match-format';
           // matchFormat.textContent = matche.match[0].matchInfo.matchFormat;
            matchHeader.appendChild(matchType);
           // matchHeader.appendChild(matchFormat);

            const matchDetails = document.createElement('div');
            matchDetails.className = 'match-detail';

            const teamScore1 = document.createElement('div');
            teamScore1.className = 'team-score';

            const teamName1 = document.createElement('span');
            teamName1.className = 'team-name';
            teamName1.textContent = matche.team1Score.team.name.split(" ").map(st => {return st.charAt(0)}).join('');
            const score1 = document.createElement('span');
            score1.className = 'score';
            var s = matche.team1Score.balls-matche.team1Score.wide-matche.team1Score.noBall;
                score1.textContent = matche.team1Score.total + "-" + matche.team1Score.wikets + "(" + Math.trunc(s/6)+"."+(s-(Math.trunc(s/6)*6)) + ")";

                teamScore1.appendChild(teamName1);
                teamScore1.appendChild(score1);
                const teamScore2 = document.createElement('div');
            teamScore2.className = 'team-score';

            const teamName2 = document.createElement('span');
            teamName2.className = 'team-name';
                teamName2.textContent = matche.team2Score.team.name.split(" ").map(st => {return st.charAt(0)}).join('');

            const score2 = document.createElement('span');
            score2.className = 'score';
            var s = matche.team2Score.balls-matche.team2Score.wide-matche.team2Score.noBall;
                score2.textContent = matche.team2Score.total + "-" + matche.team2Score.wikets + "(" + Math.trunc(s/6)+"."+(s-(Math.trunc(s/6)*6)) + ")";
                teamScore2.appendChild(teamName2);
                teamScore2.appendChild(score2);
                matchDetails.appendChild(teamScore1);
            matchDetails.appendChild(teamScore2);

            // Create and populate the match result
            const matchResult = document.createElement('div');
            matchResult.className = 'match-result';

            const result = document.createElement('span');
            result.className = 'result';
            result.textContent = matche.status;
            matchResult.appendChild(result);

            // Append all parts to the match card
            matchCard.appendChild(matchHeader);
            matchCard.appendChild(matchDetails);
            matchCard.appendChild(matchResult);

            // Append the match card to the matches div
            matchesDiv.appendChild(matchCard);
        }
        
    });
    const container = document.createElement("div");
    container.id = "container";

    const createYearGroup = (title, years) => {
      const yearGroup = document.createElement('div');
      yearGroup.classList.add('year-group');

      const heading = document.createElement('h3');
      heading.textContent = title;
      yearGroup.appendChild(heading);

      years.forEach(year => {
        const yearElement = document.createElement('a');
        yearElement.classList.add('year');
        yearElement.href = `getByYear?year=${year}`;
        yearElement.textContent = year;
        yearGroup.appendChild(yearElement);
      });

      return yearGroup;
    };

    const years = [
      { title: '2000s', years: ['2008', '2009'] },
      { title: '2010s', years: ['2010', '2011', '2012', '2013', '2014', '2015', '2018', '2019'] },
      { title: '2020s', years: ['2020', '2021', '2022', '2023'] },
    ];

    years.forEach(yearObj => {
      const yearGroup = createYearGroup(yearObj.title, yearObj.years);
      container.appendChild(yearGroup);
    });

    document.body.appendChild(matchesDiv);
    document.body.appendChild(container);
}
function showScoreCard(match){
	console.log(match.matchId);
	console.log(match.winner);
	document.body.innerHTML = '';
	var matchDetailsDiv = document.createElement("div");
	matchDetailsDiv.className = 'match-details';
	var matchStatus = document.createElement('div');
    matchStatus.className = 'match-status';
    matchStatus.innerHTML = match.winner!=null?`<p style="color: blue;">Status: ${match.status}</p>`:`<p style="color: red;">Status: ${match.status}</p>`;
    matchDetailsDiv.appendChild(matchStatus);
    matchDetailsDiv.appendChild(createTable(match.team1Score));
    matchDetailsDiv.appendChild(createTable(match.team2Score));
    
    document.body.appendChild(matchDetailsDiv);

}
function createTable(teamScore){
	var teamDiv = document.createElement("div");
	var team1 = document.createElement("div");
    var teamHeader = document.createElement("div");
    var teamName = document.createElement("h2");
    teamName.textContent = teamScore.team.name+" Innings";
    var score = document.createElement("p");
    var s = teamScore.balls-teamScore.wide-teamScore.noBall;   
    score.textContent = teamScore.total + "-" + teamScore.wikets + "(" + Math.trunc(s/6)+"."+(s-(Math.trunc(s/6)*6)) + ")";
    teamHeader.appendChild(teamName);
    teamHeader.appendChild(score);
    var inningsTable = document.createElement("table");
    inningsTable.className = "innings-table";
    
    const inningsTableHeader = document.createElement("tr");
    const inningsTableHeaderNames = ["Batter", "Dismissal", "R", "B", "4s", "6s", "SR"];
    inningsTableHeaderNames.forEach(name => {
      const th = document.createElement("th");
      th.textContent = name;
      inningsTableHeader.appendChild(th);
    });
    inningsTable.appendChild(inningsTableHeader);

    teamScore.team.players.forEach(row => {
    	console.log(row);
      if(row.batted){
    	  const tr = document.createElement("tr");
          const tdNames = ["name", "dismissal", "runsGet", "balls", "fours", "sixs", "strikeRate"];
          tdNames.forEach(name => {
            const td = document.createElement("td");
            if(name === "dismissal"){
            	if(row.out){
            		switch(row.outType){
            		case "caught":{
            			td.textContent = "c "+row.catcher+" b "+row.bowlerName;
            			break;
            		}
            		case "lbw" :{
            			td.textContent = "lbw "+"b "+row.bowlerName;
            			break;
            		}
            		case "stumped" :{
            			td.textContent = "stumped "+row.catched+" b "+row.bowlerName;
            			break;
            		}
            		case "bowled" :{
            			td.textContent = "bowled "+"b "+row.bowlerName;
            			break;
            		}
            		case "retired out" :{
            			td.textContent = "retired out "+"b "+row.bowlerName;
            			break;
            		}
            		case "run out" :{
            			td.textContent = "run out c "+row.catched+" b "+row.bowlerName;
            			break;
            		}
            		case "caught and bowled" :{
            			td.textContent = "caught and bowled "+"b "+row.bowlerName;
            			break;
            		}
            		}
            	}else{
            	
            		td.textContent = "Not Out";
            	}
            }else if (name === "strikeRate"){
        		td.textContent = Math.floor((row.runsGet/row.balls)*10000)/100;
        	}else
            td.textContent = row[name];
            tr.appendChild(td);
          });
          inningsTable.appendChild(tr);
      }
    });
    //<h3>Fall of Wickets</h3>
//<p id="fall-of-wickets"></p>
var fallOfWicketsHeader = document.createElement("h3");
fallOfWicketsHeader.textContent = "Fall of Wickets";
var fallOfWickets = document.createElement("p");
fallOfWickets.className = "fall-of-wickets";
teamScore.team.players.forEach(row => {
	  if (row.out) {
	    fallOfWickets.textContent += `${row.name} (${row.runsGet} runs, ${row.outAt} ) | `;
	  }
	});
	var bowlingTable = document.createElement("table");
	bowlingTable.className = "bowling-table";
	const bowlingTableHeader = document.createElement("tr");
	const bowlingTableHeaderNames = ["Bowler", "O", "R", "W", "NB", "WD", "ECO"];
	bowlingTableHeaderNames.forEach(name => {
	  const th = document.createElement("th");
	  th.textContent = name;
	  bowlingTableHeader.appendChild(th);
	});
	bowlingTable.appendChild(bowlingTableHeader);
	teamScore.team.players.forEach(row =>{
		if(row.bowled){
			 const tr = document.createElement("tr");
	          const tdNames = ["name", "overs", "runsGiven", "wickets", "noBall", "wide", "ECO"];
	          tdNames.forEach(name => {
	        	  const td = document.createElement("td");
	        	  if(name === "ECO"){
	        		  var o = row.overs.length;
	        		  var eco = Math.floor((row.runsGiven/o)*100)/100;
	        		  td.textContent = eco;
	        	  }else if(name === "overs"){
	        		  td.textContent = row.overs.length;
	        	  }else{
	        		  td.textContent = row[name];
	        	  }
	        	  tr.appendChild(td);
	          })
	          bowlingTable.appendChild(tr);
		}
	});
    teamDiv.appendChild(teamHeader);
    teamDiv.appendChild(inningsTable);
    teamDiv.appendChild(fallOfWicketsHeader);
    teamDiv.appendChild(fallOfWickets)
    teamDiv.appendChild(bowlingTable);
    return teamDiv;
}
var matches = <%=matchesJson%>;
document.addEventListener('DOMContentLoaded', (event) => {
    createMatchCards(matches);
});
</script>
</body>
</html>