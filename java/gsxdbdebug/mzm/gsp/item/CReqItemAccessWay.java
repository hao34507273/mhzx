/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PQueryItemAccessWay;
/*    */ 
/*    */ 
/*    */ public class CReqItemAccessWay
/*    */   extends __CReqItemAccessWay__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584723;
/*    */   public ArrayList<Integer> itemidlist;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleid = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleid, new PQueryItemAccessWay(roleid, this.itemidlist));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12584723;
/*    */   }
/*    */   
/*    */ 
/*    */   public CReqItemAccessWay()
/*    */   {
/* 34 */     this.itemidlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public CReqItemAccessWay(ArrayList<Integer> _itemidlist_) {
/* 38 */     this.itemidlist = _itemidlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.compact_uint32(this.itemidlist.size());
/* 47 */     for (Integer _v_ : this.itemidlist) {
/* 48 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 56 */       int _v_ = _os_.unmarshal_int();
/* 57 */       this.itemidlist.add(Integer.valueOf(_v_));
/*    */     }
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CReqItemAccessWay)) {
/* 68 */       CReqItemAccessWay _o_ = (CReqItemAccessWay)_o1_;
/* 69 */       if (!this.itemidlist.equals(_o_.itemidlist)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.itemidlist.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.itemidlist).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CReqItemAccessWay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */