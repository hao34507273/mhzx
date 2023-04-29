/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SyncPointRaceTitle
/*    */   extends __SyncPointRaceTitle__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617069;
/*    */   public long corps_id;
/*    */   public Octets corps_name;
/*    */   public int corps_duty;
/*    */   public int corps_badge_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617069;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SyncPointRaceTitle()
/*    */   {
/* 36 */     this.corps_name = new Octets();
/*    */   }
/*    */   
/*    */   public SyncPointRaceTitle(long _corps_id_, Octets _corps_name_, int _corps_duty_, int _corps_badge_id_) {
/* 40 */     this.corps_id = _corps_id_;
/* 41 */     this.corps_name = _corps_name_;
/* 42 */     this.corps_duty = _corps_duty_;
/* 43 */     this.corps_badge_id = _corps_badge_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.corps_id);
/* 52 */     _os_.marshal(this.corps_name);
/* 53 */     _os_.marshal(this.corps_duty);
/* 54 */     _os_.marshal(this.corps_badge_id);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.corps_id = _os_.unmarshal_long();
/* 60 */     this.corps_name = _os_.unmarshal_Octets();
/* 61 */     this.corps_duty = _os_.unmarshal_int();
/* 62 */     this.corps_badge_id = _os_.unmarshal_int();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SyncPointRaceTitle)) {
/* 72 */       SyncPointRaceTitle _o_ = (SyncPointRaceTitle)_o1_;
/* 73 */       if (this.corps_id != _o_.corps_id) return false;
/* 74 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/* 75 */       if (this.corps_duty != _o_.corps_duty) return false;
/* 76 */       if (this.corps_badge_id != _o_.corps_badge_id) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.corps_id;
/* 85 */     _h_ += this.corps_name.hashCode();
/* 86 */     _h_ += this.corps_duty;
/* 87 */     _h_ += this.corps_badge_id;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.corps_id).append(",");
/* 95 */     _sb_.append("B").append(this.corps_name.size()).append(",");
/* 96 */     _sb_.append(this.corps_duty).append(",");
/* 97 */     _sb_.append(this.corps_badge_id).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SyncPointRaceTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */