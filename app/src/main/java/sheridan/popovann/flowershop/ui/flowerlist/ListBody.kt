package sheridan.popovann.flowershop.ui.flowerlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sheridan.popovann.flowershop.domain.Flower
import coil.compose.AsyncImage
import androidx.compose.ui.text.capitalize
import sheridan.popovann.flowershop.R


@Composable
fun ListBody(
    flowerList: List<Flower>,
    modifier: Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp, horizontal = 16.dp
        ), modifier = modifier
    ) {
        items(flowerList) { flower ->
            FlowerItem(flower)
        }
    }

}

@Composable
fun FlowerItem(flower: Flower) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()

    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
        ){
            AsyncImage(
                model = "file:///android_asset/images/flowers/${flower.image}",
                contentDescription = "${flower.label}",
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .size(dimensionResource(R.dimen.image_size)),
                contentScale = ContentScale.Crop

            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Text(
                        text = flower.label.capitalize(Locale.current),
                        fontSize = 28.sp,
                        style = MaterialTheme.typography.displayMedium
                    )
                    Spacer(Modifier.weight(1f))
                    FlowerItemButton(
                        expanded = expanded,
                        onClick = { expanded = !expanded },
                    )


                }
                if (expanded) {
                    FlowerDescription(
                        flower,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_small),
                            bottom = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium)
                        )
                    )
                }
                Text(
                    text = String.format("%.2f", flower.price),
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}