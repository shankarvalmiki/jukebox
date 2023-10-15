package com.example.demo;

import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongsCommand;
import com.example.demo.commands.LoadPlayListCommand;
import com.example.demo.commands.addSongCommand;
import com.example.demo.commands.addSongToPLayListCommand;
import com.example.demo.commands.createPlayListCommand;
import com.example.demo.commands.deletePlayListCommand;
import com.example.demo.commands.deleteSongFromPlayListCommand;
import com.example.demo.commands.playNextSongCommand;
import com.example.demo.commands.playPreviousSongCommand;
import com.example.demo.commands.playSongCommand;
import com.example.demo.commands.stopSongCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IPlayListRepository;
import com.example.demo.repositories.ISongsRepository;
import com.example.demo.repositories.PlayListRepository;
import com.example.demo.repositories.SongsRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.PlayListService;
import com.example.demo.services.Player;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            //intitializing jukebox repositories
            private final IPlayListRepository playListRepository=new PlayListRepository();
            private final ISongsRepository songRepository=new SongsRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            //initializing jukebox services
            private final SongService songService= new SongService(songRepository);
            private final PlayListService playListService= new PlayListService(playListRepository, songRepository);
            private final Player player = new Player(playListRepository);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            //initializing jukebox commands
            private final addSongCommand addsongCommand= new addSongCommand(songService);
            private final createPlayListCommand createplaylistCommand = new createPlayListCommand(playListService);
            private final addSongToPLayListCommand addsongToPlayListCommand = new addSongToPLayListCommand(playListService);
            private final deleteSongFromPlayListCommand deletesongFromPlayListCommand = new deleteSongFromPlayListCommand(playListService);
            private final deletePlayListCommand deleteplaylistCommand = new deletePlayListCommand(playListService);
            private final LoadPlayListCommand loadPlayListCommand=new LoadPlayListCommand(player);
            private final playSongCommand playsongCommand= new playSongCommand(player);
            private final playNextSongCommand playnextSongCommand = new playNextSongCommand(player);
            private final playPreviousSongCommand playpreviousSongCommand = new playPreviousSongCommand(player);
            private final stopSongCommand stopsongCommand = new stopSongCommand(player);
            private final ListSongsCommand ListSongsCommand = new ListSongsCommand(songService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(),addsongCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(), addsongToPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(), createplaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(), deleteplaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(),deletesongFromPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS_COMMAND.getName(), ListSongsCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(), loadPlayListCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(), playnextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(), playsongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(), playpreviousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(), stopsongCommand);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
