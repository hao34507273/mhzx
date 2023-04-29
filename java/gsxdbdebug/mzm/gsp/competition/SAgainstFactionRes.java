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
/*    */ 
/*    */ 
/*    */ public class SAgainstFactionRes
/*    */   extends __SAgainstFactionRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598543;
/*    */   public long faction_id;
/*    */   public String faction_name;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598543;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAgainstFactionRes()
/*    */   {
/* 34 */     this.faction_id = 0L;
/* 35 */     this.faction_name = "";
/*    */   }
/*    */   
/*    */   public SAgainstFactionRes(long _faction_id_, String _faction_name_) {
/* 39 */     this.faction_id = _faction_id_;
/* 40 */     this.faction_name = _faction_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.faction_id);
/* 49 */     _os_.marshal(this.faction_name, "UTF-16LE");
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.faction_id = _os_.unmarshal_long();
/* 55 */     this.faction_name = _os_.unmarshal_String("UTF-16LE");
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SAgainstFactionRes)) {
/* 65 */       SAgainstFactionRes _o_ = (SAgainstFactionRes)_o1_;
/* 66 */       if (this.faction_id != _o_.faction_id) return false;
/* 67 */       if (!this.faction_name.equals(_o_.faction_name)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.faction_id;
/* 76 */     _h_ += this.faction_name.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.faction_id).append(",");
/* 84 */     _sb_.append("T").append(this.faction_name.length()).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SAgainstFactionRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */