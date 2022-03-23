import {React} from 'react';

export const MatchSmallCard = ({match}) => {
  return (
    <div className="MatchSmallCard">
      <h4>{match.team1} vs {match.team2}</h4>
    </div>
  );
}