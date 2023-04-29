/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class MapGroupMemberInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets model_info;
/*    */   
/*    */   public MapGroupMemberInfo()
/*    */   {
/* 15 */     this.model_info = new Octets();
/*    */   }
/*    */   
/*    */   public MapGroupMemberInfo(long _roleid_, Octets _model_info_) {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.model_info = _model_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.roleid);
/* 29 */     _os_.marshal(this.model_info);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.roleid = _os_.unmarshal_long();
/* 35 */     this.model_info = _os_.unmarshal_Octets();
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof MapGroupMemberInfo)) {
/* 42 */       MapGroupMemberInfo _o_ = (MapGroupMemberInfo)_o1_;
/* 43 */       if (this.roleid != _o_.roleid) return false;
/* 44 */       if (!this.model_info.equals(_o_.model_info)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += (int)this.roleid;
/* 53 */     _h_ += this.model_info.hashCode();
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(this.roleid).append(",");
/* 61 */     _sb_.append("B").append(this.model_info.size()).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\MapGroupMemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */