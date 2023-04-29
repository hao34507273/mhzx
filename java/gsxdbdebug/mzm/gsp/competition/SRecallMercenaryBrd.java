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
/*    */ public class SRecallMercenaryBrd
/*    */   extends __SRecallMercenaryBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598551;
/*    */   public long mercenary_factionid;
/*    */   public int mercenary_count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598551;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRecallMercenaryBrd() {}
/*    */   
/*    */ 
/*    */   public SRecallMercenaryBrd(long _mercenary_factionid_, int _mercenary_count_)
/*    */   {
/* 37 */     this.mercenary_factionid = _mercenary_factionid_;
/* 38 */     this.mercenary_count = _mercenary_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.mercenary_factionid);
/* 47 */     _os_.marshal(this.mercenary_count);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.mercenary_factionid = _os_.unmarshal_long();
/* 53 */     this.mercenary_count = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SRecallMercenaryBrd)) {
/* 63 */       SRecallMercenaryBrd _o_ = (SRecallMercenaryBrd)_o1_;
/* 64 */       if (this.mercenary_factionid != _o_.mercenary_factionid) return false;
/* 65 */       if (this.mercenary_count != _o_.mercenary_count) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.mercenary_factionid;
/* 74 */     _h_ += this.mercenary_count;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.mercenary_factionid).append(",");
/* 82 */     _sb_.append(this.mercenary_count).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRecallMercenaryBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.mercenary_factionid - _o_.mercenary_factionid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.mercenary_count - _o_.mercenary_count;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\SRecallMercenaryBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */