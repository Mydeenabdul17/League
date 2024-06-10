<%@page import="com.mydeenAbdul.league.dto.Season"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 body {
  font-family: Arial, sans-serif;
  margin: 20px;
  background-color: #f9f9f9; /* added a light gray background */
}

.season-record {
  margin-bottom: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  background-color: #fff; /* added a white background */
}

.season-record h2 {
  margin-top: 0;
  font-weight: bold;
  color: #333; /* added a darker text color */
}

table {
  border-collapse: collapse;
  width: 100%;
  margin-bottom: 20px; /* added margin bottom */
}

th, td {
  border: 1px solid #ddd; /* changed border color to a lighter gray */
  padding: 15px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
  font-weight: bold;
  color: #333; /* added a darker text color */
}

.clickable {
  cursor: pointer;
  text-decoration: underline;
  color: #337ab7; /* added a blue color for clickable text */
}

.team-stats-table,.player-stats-table {
  margin-bottom: 20px;
  border: 1px solid #ddd; /* added a border around the tables */
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.high-sixes,.high-scored,.high-sr {
  margin-bottom: 10px;
  font-weight: bold;
  color: #333; /* added a darker text color */
}

h4 {
  margin-top: 0;
  font-weight: bold;
  color: #333; /* added a darker text color */
}</style>
</head>
<body>
<%Season sesson = (Season)request.getAttribute("sesson");
ObjectMapper mapper = new ObjectMapper();
String sessonJson = mapper.writeValueAsString(sesson);
%>
<script type="text/javascript">
var seasonData = <%=sessonJson%>
//Create season record container
const seasonRecordContainer = document.createElement("div");
seasonRecordContainer.className = "season-record";
document.body.appendChild(seasonRecordContainer);

//Create season header
const seasonHeader = document.createElement("h2");
seasonHeader.textContent = `Season ${seasonData.year}`;
seasonRecordContainer.appendChild(seasonHeader);

const tHeader = document.createElement("h2")
tHeader.textContent="Teams"
//Create team stats table
const teamStatsTable = document.createElement("table");
seasonRecordContainer.appendChild(tHeader);
seasonRecordContainer.appendChild(teamStatsTable);

const teamStatsTableHead = document.createElement("thead");
teamStatsTable.appendChild(teamStatsTableHead);

const teamStatsTableHeadRow = document.createElement("tr");
teamStatsTableHead.appendChild(teamStatsTableHeadRow);

const teamStatsTableHeadCells = ["Team Name", "Runs", "Win", "Lose"];
teamStatsTableHeadCells.forEach(cell => {
const th = document.createElement("th");
th.textContent = cell;
teamStatsTableHeadRow.appendChild(th);
});

const teamStatsTableBody = document.createElement("tbody");
teamStatsTable.appendChild(teamStatsTableBody);

seasonData.teamAndPlayerStats.forEach(team => {
const teamRow = document.createElement("tr");
teamStatsTableBody.appendChild(teamRow);

const teamCells = [team.teamName, team.runsGet, team.winCount, team.loseCount];
teamCells.forEach(cell => {
  const td = document.createElement("td");
  td.textContent = cell;
  teamRow.appendChild(td);
});

const teamNameCell = teamRow.cells[0];
teamNameCell.className = "clickable";
teamNameCell.onclick = () => {
  showTeamDetails(team);
};
});
//Create high sixes section
const highSixesSection = document.createElement("h4");
highSixesSection.textContent = "High Sixes";
seasonRecordContainer.appendChild(highSixesSection);

const highSixesParagraph = document.createElement("p");
highSixesParagraph.textContent = `${seasonData.highSixes.name} (${seasonData.highSixes.sixes})`;
highSixesSection.appendChild(highSixesParagraph);

// Create high scored section
const highScoredSection = document.createElement("h4");
highScoredSection.textContent = "High Scored";
seasonRecordContainer.appendChild(highScoredSection);

const highScoredParagraph = document.createElement("p");
highScoredParagraph.textContent = `${seasonData.highScored.name} (${seasonData.highScored.total})`;
highScoredSection.appendChild(highScoredParagraph);

// Create high SR section
const highSrSection = document.createElement("h4");
highSrSection.textContent = "High SR";
seasonRecordContainer.appendChild(highSrSection);

const highSrParagraph = document.createElement("p");
highSrParagraph.textContent = `${seasonData.highSR.name} (${seasonData.highSR.sr})`;
highSrSection.appendChild(highSrParagraph);
function showTeamDetails(teamStats){
	document.body.innerHTML = '';
	const teamRecordContainer = document.createElement("div");
	teamRecordContainer.className = "season-record";
	document.body.appendChild(teamRecordContainer);
	var pheader = document.createElement("h2")
	pheader.textContent = "Players"

	// Create player stats table
	var playerStatsTable = document.createElement("table");
	teamRecordContainer.appendChild(pheader);
	teamRecordContainer.appendChild(playerStatsTable);

	var playerStatsTableHead = document.createElement("thead");
	playerStatsTable.appendChild(playerStatsTableHead);

	var playerStatsTableHeadRow = document.createElement("tr");
	playerStatsTableHead.appendChild(playerStatsTableHeadRow);

	var playerStatsTableHeadCells = ["Player Name", "Total", "Sixes", "Fours", "HighScore", "Overs", "Balls", "Wickets", "SR"];
	playerStatsTableHeadCells.forEach(cell => {
	  var th = document.createElement("th");
	  th.textContent = cell;
	  playerStatsTableHeadRow.appendChild(th);
	});

	var playerStatsTableBody = document.createElement("tbody");
	playerStatsTable.appendChild(playerStatsTableBody);

	teamStats.playerStats.forEach(player => {
	  var playerRow = document.createElement("tr");
	  playerStatsTableBody.appendChild(playerRow);

	  var playerCells = [player.name, player.total, player.sixes,player.fours,player.highScore,player.overs,player.balls,player.wickets, player.sr];
	  playerCells.forEach(cell => {
	    var td = document.createElement("td");
	    td.textContent = cell;
	    playerRow.appendChild(td);
	  });

	  var playerNameCell = playerRow.cells[0];
	  playerNameCell.className = "clickable";
	  playerNameCell.onclick = () => {
	    alert(`Player ${player.name} details`);
	  };
	});
	const runsSection = document.createElement("h4");
	runsSection.textContent = "Total Score";
	teamRecordContainer.appendChild(runsSection);

	const runsParagraph = document.createElement("p");
	runsParagraph.textContent = `${teamStats.runsGet} `;
	runsSection.appendChild(runsParagraph);
	
	const winsSection = document.createElement("h4");
	winsSection.textContent = "Wins Count";
	teamRecordContainer.appendChild(highScoredSection);

	const winsParagraph = document.createElement("p");
	winsParagraph.textContent = `${teamStats.winsCount} `;
	winsSection.appendChild(winsParagraph);
	
	const loseSection = document.createElement("h4");
	loseSection.textContent = "Lose Count";
	teamRecordContainer.appendChild(loseSection);

	const loseParagraph = document.createElement("p");
	loseParagraph.textContent = `${teamStats.loseCount} `;
	loseSection.appendChild(loeParagraph);
}</script>
</body>
</html>