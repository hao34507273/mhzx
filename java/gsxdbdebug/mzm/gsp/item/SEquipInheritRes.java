/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SEquipInheritRes
/*    */   extends __SEquipInheritRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584746;
/*    */   public int strengthlevel;
/*    */   public int isinherithun;
/*    */   public ArrayList<ExtraProBean> newexprolist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584746;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEquipInheritRes()
/*    */   {
/* 33 */     this.newexprolist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SEquipInheritRes(int _strengthlevel_, int _isinherithun_, ArrayList<ExtraProBean> _newexprolist_) {
/* 37 */     this.strengthlevel = _strengthlevel_;
/* 38 */     this.isinherithun = _isinherithun_;
/* 39 */     this.newexprolist = _newexprolist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (ExtraProBean _v_ : this.newexprolist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.strengthlevel);
/* 50 */     _os_.marshal(this.isinherithun);
/* 51 */     _os_.compact_uint32(this.newexprolist.size());
/* 52 */     for (ExtraProBean _v_ : this.newexprolist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.strengthlevel = _os_.unmarshal_int();
/* 60 */     this.isinherithun = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 62 */       ExtraProBean _v_ = new ExtraProBean();
/* 63 */       _v_.unmarshal(_os_);
/* 64 */       this.newexprolist.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SEquipInheritRes)) {
/* 75 */       SEquipInheritRes _o_ = (SEquipInheritRes)_o1_;
/* 76 */       if (this.strengthlevel != _o_.strengthlevel) return false;
/* 77 */       if (this.isinherithun != _o_.isinherithun) return false;
/* 78 */       if (!this.newexprolist.equals(_o_.newexprolist)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.strengthlevel;
/* 87 */     _h_ += this.isinherithun;
/* 88 */     _h_ += this.newexprolist.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.strengthlevel).append(",");
/* 96 */     _sb_.append(this.isinherithun).append(",");
/* 97 */     _sb_.append(this.newexprolist).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SEquipInheritRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */