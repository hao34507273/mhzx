/*    */ package mzm.gsp.competition;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SCompetitionTitle
/*    */   extends __SCompetitionTitle__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598536;
/*    */   public long faction_id;
/*    */   public String faction_name;
/*    */   public int faction_duty;
/*    */   public int display_type;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598536;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCompetitionTitle()
/*    */   {
/* 36 */     this.faction_name = "";
/*    */   }
/*    */   
/*    */   public SCompetitionTitle(long _faction_id_, String _faction_name_, int _faction_duty_, int _display_type_) {
/* 40 */     this.faction_id = _faction_id_;
/* 41 */     this.faction_name = _faction_name_;
/* 42 */     this.faction_duty = _faction_duty_;
/* 43 */     this.display_type = _display_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.faction_id);
/* 52 */     _os_.marshal(this.faction_name, "UTF-16LE");
/* 53 */     _os_.marshal(this.faction_duty);
/* 54 */     _os_.marshal(this.display_type);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.faction_id = _os_.unmarshal_long();
/* 60 */     this.faction_name = _os_.unmarshal_String("UTF-16LE");
/* 61 */     this.faction_duty = _os_.unmarshal_int();
/* 62 */     this.display_type = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SCompetitionTitle)) {
/* 72 */       SCompetitionTitle _o_ = (SCompetitionTitle)_o1_;
/* 73 */       if (this.faction_id != _o_.faction_id) return false;
/* 74 */       if (!this.faction_name.equals(_o_.faction_name)) return false;
/* 75 */       if (this.faction_duty != _o_.faction_duty) return false;
/* 76 */       if (this.display_type != _o_.display_type) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.faction_id;
/* 85 */     _h_ += this.faction_name.hashCode();
/* 86 */     _h_ += this.faction_duty;
/* 87 */     _h_ += this.display_type;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.faction_id).append(",");
/* 95 */     _sb_.append("T").append(this.faction_name.length()).append(",");
/* 96 */     _sb_.append(this.faction_duty).append(",");
/* 97 */     _sb_.append(this.display_type).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SCompetitionTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */