/*    */ package mzm.gsp.floor;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RoleFloorActivityInfo implements Marshal
/*    */ {
/*    */   public ArrayList<RoleFloorInfo> finishfloor;
/*    */   public ArrayList<Integer> historyfinishfloors;
/*    */   
/*    */   public RoleFloorActivityInfo()
/*    */   {
/* 15 */     this.finishfloor = new ArrayList();
/* 16 */     this.historyfinishfloors = new ArrayList();
/*    */   }
/*    */   
/*    */   public RoleFloorActivityInfo(ArrayList<RoleFloorInfo> _finishfloor_, ArrayList<Integer> _historyfinishfloors_) {
/* 20 */     this.finishfloor = _finishfloor_;
/* 21 */     this.historyfinishfloors = _historyfinishfloors_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     for (RoleFloorInfo _v_ : this.finishfloor)
/* 26 */       if (!_v_._validator_()) return false;
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.compact_uint32(this.finishfloor.size());
/* 32 */     for (RoleFloorInfo _v_ : this.finishfloor) {
/* 33 */       _os_.marshal(_v_);
/*    */     }
/* 35 */     _os_.compact_uint32(this.historyfinishfloors.size());
/* 36 */     for (Integer _v_ : this.historyfinishfloors) {
/* 37 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 44 */       RoleFloorInfo _v_ = new RoleFloorInfo();
/* 45 */       _v_.unmarshal(_os_);
/* 46 */       this.finishfloor.add(_v_);
/*    */     }
/* 48 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 50 */       int _v_ = _os_.unmarshal_int();
/* 51 */       this.historyfinishfloors.add(Integer.valueOf(_v_));
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof RoleFloorActivityInfo)) {
/* 59 */       RoleFloorActivityInfo _o_ = (RoleFloorActivityInfo)_o1_;
/* 60 */       if (!this.finishfloor.equals(_o_.finishfloor)) return false;
/* 61 */       if (!this.historyfinishfloors.equals(_o_.historyfinishfloors)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.finishfloor.hashCode();
/* 70 */     _h_ += this.historyfinishfloors.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.finishfloor).append(",");
/* 78 */     _sb_.append(this.historyfinishfloors).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\RoleFloorActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */