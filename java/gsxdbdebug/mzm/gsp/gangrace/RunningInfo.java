/*    */ package mzm.gsp.gangrace;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RunningInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int playeridx;
/*    */   public ArrayList<ActionInfo> actioninfos;
/*    */   
/*    */   public RunningInfo()
/*    */   {
/* 13 */     this.actioninfos = new ArrayList();
/*    */   }
/*    */   
/*    */   public RunningInfo(int _playeridx_, ArrayList<ActionInfo> _actioninfos_) {
/* 17 */     this.playeridx = _playeridx_;
/* 18 */     this.actioninfos = _actioninfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (ActionInfo _v_ : this.actioninfos)
/* 23 */       if (!_v_._validator_()) return false;
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.playeridx);
/* 29 */     _os_.compact_uint32(this.actioninfos.size());
/* 30 */     for (ActionInfo _v_ : this.actioninfos) {
/* 31 */       _os_.marshal(_v_);
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     this.playeridx = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 39 */       ActionInfo _v_ = new ActionInfo();
/* 40 */       _v_.unmarshal(_os_);
/* 41 */       this.actioninfos.add(_v_);
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof RunningInfo)) {
/* 49 */       RunningInfo _o_ = (RunningInfo)_o1_;
/* 50 */       if (this.playeridx != _o_.playeridx) return false;
/* 51 */       if (!this.actioninfos.equals(_o_.actioninfos)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.playeridx;
/* 60 */     _h_ += this.actioninfos.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.playeridx).append(",");
/* 68 */     _sb_.append(this.actioninfos).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\RunningInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */