import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HeroComponent } from './components/hero/hero.component';
import { HeaderComponent } from "../../layout/header/header.component";
import { TestimonialsComponent } from "./components/testimonials/testimonials.component";
import { ProblemComponent } from "./components/problem/problem.component";
import { SolutionComponent } from "./components/solution/solution.component";
import { CommunityComponent } from "./components/community/community.component";
import { BenefitsComponent } from "./components/benefits/benefits.component";
import { FaqComponent } from "./components/faq/faq.component";

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [
    CommonModule,
    HeroComponent,
    HeaderComponent,
    TestimonialsComponent,
    ProblemComponent,
    SolutionComponent,
    CommunityComponent,
    BenefitsComponent,
    FaqComponent,
],
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.css']
})
export class LandingComponent {}