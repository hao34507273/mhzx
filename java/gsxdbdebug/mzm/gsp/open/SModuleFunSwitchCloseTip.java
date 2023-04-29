/*    */ package mzm.gsp.open;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SModuleFunSwitchCloseTip
/*    */   extends __SModuleFunSwitchCloseTip__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599044;
/*    */   public int moduleid;
/*    */   public int funid;
/*    */   public LinkedList<String> params;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599044;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SModuleFunSwitchCloseTip()
/*    */   {
/* 35 */     this.params = new LinkedList();
/*    */   }
/*    */   
/*    */   public SModuleFunSwitchCloseTip(int _moduleid_, int _funid_, LinkedList<String> _params_) {
/* 39 */     this.moduleid = _moduleid_;
/* 40 */     this.funid = _funid_;
/* 41 */     this.params = _params_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.moduleid);
/* 50 */     _os_.marshal(this.funid);
/* 51 */     _os_.compact_uint32(this.params.size());
/* 52 */     for (String _v_ : this.params) {
/* 53 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.moduleid = _os_.unmarshal_int();
/* 60 */     this.funid = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 64 */       this.params.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SModuleFunSwitchCloseTip)) {
/* 75 */       SModuleFunSwitchCloseTip _o_ = (SModuleFunSwitchCloseTip)_o1_;
/* 76 */       if (this.moduleid != _o_.moduleid) return false;
/* 77 */       if (this.funid != _o_.funid) return false;
/* 78 */       if (!this.params.equals(_o_.params)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.moduleid;
/* 87 */     _h_ += this.funid;
/* 88 */     _h_ += this.params.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.moduleid).append(",");
/* 96 */     _sb_.append(this.funid).append(",");
/* 97 */     _sb_.append(this.params).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\open\SModuleFunSwitchCloseTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */