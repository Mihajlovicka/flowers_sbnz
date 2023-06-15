
export class BackwardGroupedDiseases{
  disease:Disease = new Disease();
  symptoms:Symptom[] = []
  max:boolean=false
}

export class Disease{
  disease:string = ''
}

export class Symptom{
  symptom:string = ''
  cause:string = ''
  treatment:string = ''
}
