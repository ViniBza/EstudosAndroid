package vinibza.com.listadegames

import vinibza.com.listadegames.model.Game

class DataSource {

    companion object {
        fun setDataSet() : ArrayList<Game>{
             var list: ArrayList<Game> = ArrayList()

            list.add(
                Game(
                    "God of War",
                    "RPG / Adventure",
                    "http://infobrothers.com.br/wp-content/uploads/2016/06/god-of-war-4-ps4-infobrothers-800x450.jpg",
                    "https://pt.wikipedia.org/wiki/God_of_War"
                )
            )

            list.add(
                Game(
                    "Demon's Souls",
                    "Souls Like / RPG",
                    "https://gmedia.playstation.com/is/image/SIEPDC/demons-souls-listing-thumb-01-en-02oct20?",
                    "https://pt.wikipedia.org/wiki/Demon%27s_Souls"
                )
            )

            list.add(
                Game(
                    "Dark Souls II",
                    "Souls Like / RPG",
                    "https://ocapacitor.com/wp-content/uploads/2018/01/Dark-Souls-2.jpg",
                    "https://pt.wikipedia.org/wiki/Souls_(s%C3%A9rie)"
                )
            )

            list.add(
                Game(
                    "The Witcher 3: Wild Hunt",
                    "RPG / Adventure",
                    "https://image.api.playstation.com/vulcan/img/rnd/202009/2913/TQKAd8U6hnIFQIIcz6qnFh8C.png",
                    "https://pt.wikipedia.org/wiki/The_Witcher_3:_Wild_Hunt"
                )
            )

            list.add(
                Game(
                    "Uncharted",
                    "Adventure",
                    "https://cdn.ome.lt/6D6eClxEE0D1hyb2f2AahDPhzvI=/770x0/smart/uploads/conteudo/fotos/Uncharted-4.jpg",
                    "https://pt.wikipedia.org/wiki/Uncharted"
                )
            )

            list.add(
                Game(
                    "NARUTO SHIPPUDEN Ultimate Ninja STORM 4 Road To Boruto ",
                    "Batle / Adventure",
                    "https://image.api.playstation.com/cdn/EP0700/CUSA06210_00/p4461AvBMbNi2S9dsmKloUhD4iMbJbaH.png",
                    "https://pt.wikipedia.org/wiki/Naruto_Shippuden:_Ultimate_Ninja_Storm_4"
                )
            )

            list.add(
                Game(
                    "Outlast",
                    "Survivor Horror",
                    "https://image.api.playstation.com/cdn/UP2113/CUSA00325_00/PmjaXkhZZhTsAq6OZYuZIK3TFOmvF6Wj.png",
                    "https://pt.wikipedia.org/wiki/Outlast"
                )
            )

            list.add(
                Game(
                    "Outlast II",
                    "Survivor Horror",
                    "http://pm1.narvii.com/6697/dc00484ed6e85ef7c7ae47449991926cae986505_00.jpg",
                    "https://pt.wikipedia.org/wiki/Outlast_2"
                )
            )

            list.add(
                Game(
                    "Metal Gear Solid V: The Phantom Pain",
                    "Adventure / RPG",
                    "https://upload.wikimedia.org/wikipedia/pt/1/19/MGS5_TPP.jpg",
                    "https://pt.wikipedia.org/wiki/Metal_Gear_Solid_V:_The_Phantom_Pain")
            )

            list.add(
                Game(
                    "Super Bomberman R",
                    "Adventure",
                    "https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_SuperBombermanR_image1600w.jpg",
                    "https://pt.wikipedia.org/wiki/Super_Bomberman_R"
                )
            )

            list.add(
                Game(
                    "DmC: Devil May Cry",
                    "Adventure / Hack and slash",
                    "https://cdn-products.eneba.com/resized-products/iQlB8hB_350x200_1x-0.jpg",
                    "https://pt.wikipedia.org/wiki/DmC:_Devil_May_Cry"
                )
            )

            list.add(
                Game(
                    "Crash Bandicoot",
                    "Adventure",
                    "https://image.api.playstation.com/cdn/UP0002/CUSA07402_00/03ZtrPdjasIxzi8QrzOb2zCIHLMydFbh.png",
                    "https://pt.wikipedia.org/wiki/Crash_Bandicoot_N._Sane_Trilogy"
                )
            )

            list.add(
                Game(
                    "Ghost of Tsushima",
                    "RPG",
                    "https://upload.wikimedia.org/wikipedia/pt/d/dc/Ghost_of_Tsushima_capa.png",
                    "https://pt.wikipedia.org/wiki/Ghost_of_Tsushima"
                )
            )

            list.add(
                Game(
                    "Cyberpunk 2077",
                    "RPG / Batle / FPS",
                    "https://upload.wikimedia.org/wikipedia/pt/f/f7/Cyberpunk_2077_capa.png",
                    "https://pt.wikipedia.org/wiki/Cyberpunk_2077"
                )
            )

            list.add(
                Game(
                    "The Last of Us",
                    "Adventure / FPS",
                    "https://gmedia.playstation.com/is/image/SIEPDC/the-last-of-us-remastered-pack-01-ps4-en-23jul20?",
                    "https://pt.wikipedia.org/wiki/The_Last_of_Us"
                )
            )

            list.add(
                Game(
                    "Horizon Zero Dawn",
                    "RPG / Adventure",
                    "https://upload.wikimedia.org/wikipedia/pt/d/d0/Horizon_Zero_Dawn_capa.png",
                    "https://pt.wikipedia.org/wiki/Horizon_Zero_Dawn")
            )

            return list
        }

    }
}