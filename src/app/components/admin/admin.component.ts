import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ParticipationModalComponent } from 'src/app/participation-modal/participation-modal.component';
import { PlayService } from 'src/app/play.service';
import { UserAuthService } from 'src/app/user-auth.service';
import { User } from 'src/app/user/user';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css', './responsive.component.css' ]
  
})
export class AdminComponent implements OnInit{
  isLoggedIn = false;
  numberWon : number = 0 ;
  numberLeftToWin : number = 0;
  isAdmin = false;
 
  winners: Winner[] = [];

  constructor(public userAuthService: UserAuthService,private playService : PlayService,  private router: Router , public dialog: MatDialog) {}

  ngOnInit(): void {
    this.isAdmin = localStorage.getItem('isAdmin') === 'true';
    if(localStorage.getItem('token') == "" || localStorage.getItem('token') == null){
       this.router.navigateByUrl('/')
     }else {
      this.loadStats();
      this.loadWinners() ;
     }
   }

  checkLogin(): boolean {
    return this.isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
  }  


  loadStats() {
    this.playService.playStatis()
    .then(({data}) => {
      this.numberWon =  data.numberWon;
      this.numberLeftToWin = data.numberLeftToWin
    }).catch(error => {
      return error
    })
  }


  loadWinners() {
    this.playService.winnersStatis()
    .then(({data}) => {
      this.winners = data ;
    }).catch(error => {
      return error
    })
  }

  
  getType(type: string): string {
    if (type ==  "THE") return "Infuseur à thé!";
    if (type ==  "DTX") return "Boite de 100g d’un thé détox ou d’infusion!";
    if (type ==  "THS") return "Boite de 100g d’un thé signature!";
    if (type ==  "C39") return "Coffret découverte d’une valeur de 39€!";
    return "Coffret découverte d’une valeur de 69€!";
  }
}

interface Winner {
  number: string;
  winType: string;
  username :string;
}
