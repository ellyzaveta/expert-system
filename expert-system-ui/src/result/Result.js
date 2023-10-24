import React, { useState, useEffect } from 'react';
import { PieChart, Pie, Cell, Tooltip, Legend } from 'recharts';
import { Paper } from '@mui/material';

const COLORS = ['#5296D5', '#D65745', '#F8BF70'];


const Result = ({data}) => {

    const renderCustomizedLabel = ({
          cx, cy, midAngle, innerRadius, outerRadius, percent, index
        }) => {
          const RADIAN = Math.PI / 180;
          const radius = innerRadius + (outerRadius - innerRadius) * 0.5;
          const x = cx + radius * Math.cos(-midAngle * RADIAN);
          const y = cy + radius * Math.sin(-midAngle * RADIAN);
        
          return (
            <text x={x} y={y} fill="white" textAnchor="middle" dominantBaseline="central">
              {`${(percent * 100).toFixed(0)}%`}
            </text>
          );
        };

    return (
        <PieChart width={400} height={400} style={{ marginTop: '-100px', marginBottom: '-100px'}}>
        <Pie
			dataKey="value"
			isAnimationActive={false}
			data={data}
			cx="50%"
			cy="50%"
			outerRadius={150}
			fill="#8884d8"
			label={renderCustomizedLabel}
   			labelLine={false}
		>
		{data.map((entry, index) => (
			<Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
		))}
		</Pie>
		<Tooltip />
        </PieChart>
    );
}

export default Result;