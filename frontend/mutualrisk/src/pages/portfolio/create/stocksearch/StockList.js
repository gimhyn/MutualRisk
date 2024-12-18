import { Box, List } from '@mui/material';
import { colors } from 'constants/colors';
import StockListItem from 'pages/portfolio/create/stocksearch/StockListItem';
import HorizontalScrollContainer from 'components/scroll/HorizontalScrollContainer';
import useAssetStore from 'stores/useAssetStore';
import { useEffect } from 'react';

const StockList = ({ assets }) => {
	const { tempAssets, toggleTempAsset } = useAssetStore(state => ({
		tempAssets: state.tempAssets,
		toggleTempAsset: state.toggleTempAsset,
	}));

	useEffect(() => {
		console.log('tempasset', tempAssets);
	}, [tempAssets]);
	return (
		<HorizontalScrollContainer>
			<List
				sx={{
					display: 'flex',
					flexDirection: 'row',

					m: '10px',
				}}>
				{assets &&
					assets.map(asset => (
						<StockListItem
							key={asset.assetId}
							name={asset.name}
							imagePath={asset.imagePath}
							imageName={asset.imageName}
							clicked={tempAssets.has(asset)}
							onClick={() => toggleTempAsset(asset)}
						/>
					))}
			</List>
		</HorizontalScrollContainer>
	);
};

export default StockList;
