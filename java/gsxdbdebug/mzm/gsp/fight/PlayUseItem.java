/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class PlayUseItem implements Marshal
/*    */ {
/*    */   public int fighterid;
/*    */   public FighterStatus releaserstatus;
/*    */   public int itemcfgid;
/*    */   public HashMap<Integer, FighterStatus> targetstatus;
/*    */   
/*    */   public PlayUseItem()
/*    */   {
/* 17 */     this.releaserstatus = new FighterStatus();
/* 18 */     this.targetstatus = new HashMap();
/*    */   }
/*    */   
/*    */   public PlayUseItem(int _fighterid_, FighterStatus _releaserstatus_, int _itemcfgid_, HashMap<Integer, FighterStatus> _targetstatus_) {
/* 22 */     this.fighterid = _fighterid_;
/* 23 */     this.releaserstatus = _releaserstatus_;
/* 24 */     this.itemcfgid = _itemcfgid_;
/* 25 */     this.targetstatus = _targetstatus_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.releaserstatus._validator_()) return false;
/* 30 */     for (Map.Entry<Integer, FighterStatus> _e_ : this.targetstatus.entrySet()) {
/* 31 */       if (!((FighterStatus)_e_.getValue())._validator_()) return false;
/*    */     }
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.fighterid);
/* 38 */     _os_.marshal(this.releaserstatus);
/* 39 */     _os_.marshal(this.itemcfgid);
/* 40 */     _os_.compact_uint32(this.targetstatus.size());
/* 41 */     for (Map.Entry<Integer, FighterStatus> _e_ : this.targetstatus.entrySet()) {
/* 42 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 43 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 49 */     this.fighterid = _os_.unmarshal_int();
/* 50 */     this.releaserstatus.unmarshal(_os_);
/* 51 */     this.itemcfgid = _os_.unmarshal_int();
/* 52 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 54 */       int _k_ = _os_.unmarshal_int();
/* 55 */       FighterStatus _v_ = new FighterStatus();
/* 56 */       _v_.unmarshal(_os_);
/* 57 */       this.targetstatus.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof PlayUseItem)) {
/* 65 */       PlayUseItem _o_ = (PlayUseItem)_o1_;
/* 66 */       if (this.fighterid != _o_.fighterid) return false;
/* 67 */       if (!this.releaserstatus.equals(_o_.releaserstatus)) return false;
/* 68 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/* 69 */       if (!this.targetstatus.equals(_o_.targetstatus)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.fighterid;
/* 78 */     _h_ += this.releaserstatus.hashCode();
/* 79 */     _h_ += this.itemcfgid;
/* 80 */     _h_ += this.targetstatus.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.fighterid).append(",");
/* 88 */     _sb_.append(this.releaserstatus).append(",");
/* 89 */     _sb_.append(this.itemcfgid).append(",");
/* 90 */     _sb_.append(this.targetstatus).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayUseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */