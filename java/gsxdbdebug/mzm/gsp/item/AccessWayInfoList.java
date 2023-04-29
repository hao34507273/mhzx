/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class AccessWayInfoList implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<AccessWayInfo> accessways;
/*    */   
/*    */   public AccessWayInfoList()
/*    */   {
/* 12 */     this.accessways = new ArrayList();
/*    */   }
/*    */   
/*    */   public AccessWayInfoList(ArrayList<AccessWayInfo> _accessways_) {
/* 16 */     this.accessways = _accessways_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (AccessWayInfo _v_ : this.accessways)
/* 21 */       if (!_v_._validator_()) return false;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.accessways.size());
/* 27 */     for (AccessWayInfo _v_ : this.accessways) {
/* 28 */       _os_.marshal(_v_);
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 35 */       AccessWayInfo _v_ = new AccessWayInfo();
/* 36 */       _v_.unmarshal(_os_);
/* 37 */       this.accessways.add(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof AccessWayInfoList)) {
/* 45 */       AccessWayInfoList _o_ = (AccessWayInfoList)_o1_;
/* 46 */       if (!this.accessways.equals(_o_.accessways)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.accessways.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.accessways).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\AccessWayInfoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */