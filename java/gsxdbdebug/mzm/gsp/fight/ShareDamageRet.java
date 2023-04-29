/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class ShareDamageRet implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int targetid;
/*    */   public FighterStatus sharedamagestatus;
/*    */   public HashMap<Integer, FighterStatus> statusmap;
/*    */   
/*    */   public ShareDamageRet()
/*    */   {
/* 14 */     this.sharedamagestatus = new FighterStatus();
/* 15 */     this.statusmap = new HashMap();
/*    */   }
/*    */   
/*    */   public ShareDamageRet(int _targetid_, FighterStatus _sharedamagestatus_, HashMap<Integer, FighterStatus> _statusmap_) {
/* 19 */     this.targetid = _targetid_;
/* 20 */     this.sharedamagestatus = _sharedamagestatus_;
/* 21 */     this.statusmap = _statusmap_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     if (!this.sharedamagestatus._validator_()) return false;
/* 26 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/* 27 */       if (!((FighterStatus)_e_.getValue())._validator_()) return false;
/*    */     }
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.targetid);
/* 34 */     _os_.marshal(this.sharedamagestatus);
/* 35 */     _os_.compact_uint32(this.statusmap.size());
/* 36 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/* 37 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 38 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*    */     }
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     this.targetid = _os_.unmarshal_int();
/* 45 */     this.sharedamagestatus.unmarshal(_os_);
/* 46 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 48 */       int _k_ = _os_.unmarshal_int();
/* 49 */       FighterStatus _v_ = new FighterStatus();
/* 50 */       _v_.unmarshal(_os_);
/* 51 */       this.statusmap.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof ShareDamageRet)) {
/* 59 */       ShareDamageRet _o_ = (ShareDamageRet)_o1_;
/* 60 */       if (this.targetid != _o_.targetid) return false;
/* 61 */       if (!this.sharedamagestatus.equals(_o_.sharedamagestatus)) return false;
/* 62 */       if (!this.statusmap.equals(_o_.statusmap)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.targetid;
/* 71 */     _h_ += this.sharedamagestatus.hashCode();
/* 72 */     _h_ += this.statusmap.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.targetid).append(",");
/* 80 */     _sb_.append(this.sharedamagestatus).append(",");
/* 81 */     _sb_.append(this.statusmap).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\ShareDamageRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */