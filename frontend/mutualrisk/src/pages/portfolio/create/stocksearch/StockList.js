import { Box, List } from '@mui/material';
import { colors } from 'constants/colors';
import StockSearchBar from 'pages/portfolio/create/stocksearch/StockSearchBar';
import StockListItem from 'pages/portfolio/create/stocksearch/StockListItem';
import { useState } from 'react';

const StockList = ({
	assets,
	selectedStocks,
	onStockSelect,
	showSearchBar = true,
}) => {
	console.log(showSearchBar);
	return (
		<Box>
			<Box
				sx={{
					fontSize: '20px',
					fontWeight: 'bold',
					color: colors.text.main,
				}}>
				{'종목 검색'}
			</Box>
			{showSearchBar && <StockSearchBar />}
			<List
				sx={{
					display: 'flex',
					flexDirection: 'row',
				}}>
				{assets &&
					assets.map(asset => (
						<StockListItem
							key={asset.assetId}
							name={asset.name}
							imagePath={asset.imagePath}
							imageName={asset.imageName}
							clicked={selectedStocks.some(
								selected => selected.assetId === asset.assetId
							)}
							onClick={() => onStockSelect(asset)}
						/>
					))}
			</List>
		</Box>
	);
};

export default StockList;
