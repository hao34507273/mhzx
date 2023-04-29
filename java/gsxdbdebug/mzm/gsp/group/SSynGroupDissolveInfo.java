/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
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
/*    */ public class SSynGroupDissolveInfo
/*    */   extends __SSynGroupDissolveInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605223;
/*    */   public ArrayList<Octets> group_dissolve_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605223;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynGroupDissolveInfo()
/*    */   {
/* 33 */     this.group_dissolve_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynGroupDissolveInfo(ArrayList<Octets> _group_dissolve_infos_) {
/* 37 */     this.group_dissolve_infos = _group_dissolve_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.group_dissolve_infos.size());
/* 46 */     for (Octets _v_ : this.group_dissolve_infos) {
/* 47 */       _os_.marshal(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       Octets _v_ = _os_.unmarshal_Octets();
/* 56 */       this.group_dissolve_infos.add(_v_);
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynGroupDissolveInfo)) {
/* 67 */       SSynGroupDissolveInfo _o_ = (SSynGroupDissolveInfo)_o1_;
/* 68 */       if (!this.group_dissolve_infos.equals(_o_.group_dissolve_infos)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.group_dissolve_infos.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.group_dissolve_infos).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\SSynGroupDissolveInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */