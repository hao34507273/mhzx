/*    */ package mzm.gsp.firework;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.map.Location;
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
/*    */ public class SPlayFindFireworkSucEffectBro
/*    */   extends __SPlayFindFireworkSucEffectBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625160;
/*    */   public int mapid;
/*    */   public Location location;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625160;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPlayFindFireworkSucEffectBro()
/*    */   {
/* 34 */     this.location = new Location();
/*    */   }
/*    */   
/*    */   public SPlayFindFireworkSucEffectBro(int _mapid_, Location _location_) {
/* 38 */     this.mapid = _mapid_;
/* 39 */     this.location = _location_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.location._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.mapid);
/* 49 */     _os_.marshal(this.location);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.mapid = _os_.unmarshal_int();
/* 55 */     this.location.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SPlayFindFireworkSucEffectBro)) {
/* 65 */       SPlayFindFireworkSucEffectBro _o_ = (SPlayFindFireworkSucEffectBro)_o1_;
/* 66 */       if (this.mapid != _o_.mapid) return false;
/* 67 */       if (!this.location.equals(_o_.location)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.mapid;
/* 76 */     _h_ += this.location.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.mapid).append(",");
/* 84 */     _sb_.append(this.location).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SPlayFindFireworkSucEffectBro _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.mapid - _o_.mapid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.location.compareTo(_o_.location);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\SPlayFindFireworkSucEffectBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */