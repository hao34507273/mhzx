/*    */ package mzm.gsp.zoo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class AnimalInfo implements Marshal
/*    */ {
/*    */   public long animalid;
/*    */   public int stage;
/*    */   public Octets name;
/*    */   public Octets stage_info;
/*    */   
/*    */   public AnimalInfo()
/*    */   {
/* 17 */     this.name = new Octets();
/* 18 */     this.stage_info = new Octets();
/*    */   }
/*    */   
/*    */   public AnimalInfo(long _animalid_, int _stage_, Octets _name_, Octets _stage_info_) {
/* 22 */     this.animalid = _animalid_;
/* 23 */     this.stage = _stage_;
/* 24 */     this.name = _name_;
/* 25 */     this.stage_info = _stage_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.animalid);
/* 34 */     _os_.marshal(this.stage);
/* 35 */     _os_.marshal(this.name);
/* 36 */     _os_.marshal(this.stage_info);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.animalid = _os_.unmarshal_long();
/* 42 */     this.stage = _os_.unmarshal_int();
/* 43 */     this.name = _os_.unmarshal_Octets();
/* 44 */     this.stage_info = _os_.unmarshal_Octets();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof AnimalInfo)) {
/* 51 */       AnimalInfo _o_ = (AnimalInfo)_o1_;
/* 52 */       if (this.animalid != _o_.animalid) return false;
/* 53 */       if (this.stage != _o_.stage) return false;
/* 54 */       if (!this.name.equals(_o_.name)) return false;
/* 55 */       if (!this.stage_info.equals(_o_.stage_info)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += (int)this.animalid;
/* 64 */     _h_ += this.stage;
/* 65 */     _h_ += this.name.hashCode();
/* 66 */     _h_ += this.stage_info.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.animalid).append(",");
/* 74 */     _sb_.append(this.stage).append(",");
/* 75 */     _sb_.append("B").append(this.name.size()).append(",");
/* 76 */     _sb_.append("B").append(this.stage_info.size()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\AnimalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */