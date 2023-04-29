/*    */ package mzm.gsp.magicmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.magicmark.main.PCExtendMagicMarkTimeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CExtendMagicMarkTimeReq
/*    */   extends __CExtendMagicMarkTimeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609543;
/*    */   public ArrayList<Integer> magicmarkitems;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCExtendMagicMarkTimeReq(roleid, this.magicmarkitems));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12609543;
/*    */   }
/*    */   
/*    */ 
/*    */   public CExtendMagicMarkTimeReq()
/*    */   {
/* 35 */     this.magicmarkitems = new ArrayList();
/*    */   }
/*    */   
/*    */   public CExtendMagicMarkTimeReq(ArrayList<Integer> _magicmarkitems_) {
/* 39 */     this.magicmarkitems = _magicmarkitems_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.magicmarkitems.size());
/* 48 */     for (Integer _v_ : this.magicmarkitems) {
/* 49 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.magicmarkitems.add(Integer.valueOf(_v_));
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CExtendMagicMarkTimeReq)) {
/* 69 */       CExtendMagicMarkTimeReq _o_ = (CExtendMagicMarkTimeReq)_o1_;
/* 70 */       if (!this.magicmarkitems.equals(_o_.magicmarkitems)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.magicmarkitems.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.magicmarkitems).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\CExtendMagicMarkTimeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */