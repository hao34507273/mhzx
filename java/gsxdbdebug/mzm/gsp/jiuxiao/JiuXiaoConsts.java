/*    */ package mzm.gsp.jiuxiao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JiuXiaoConsts
/*    */   implements Marshal, Comparable<JiuXiaoConsts>
/*    */ {
/*    */   public static final int ENTER_JIU_XIAO_MAP_SERVICEID = 150205001;
/*    */   public static final int ENTER_JIU_XIAO_ROOM_SERVICEID = 150205000;
/*    */   public static final int JIU_XIAO_WAIT_STAGE = 0;
/*    */   public static final int JIU_XIAO_ENTER_STAGE = 1;
/*    */   public static final int JIU_XIAO_TIP_STAGE = 2;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 32 */     if (_o1_ == this) return true;
/* 33 */     if ((_o1_ instanceof JiuXiaoConsts)) {
/* 34 */       return true;
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 40 */     int _h_ = 0;
/* 41 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 45 */     StringBuilder _sb_ = new StringBuilder();
/* 46 */     _sb_.append("(");
/* 47 */     _sb_.append(")");
/* 48 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(JiuXiaoConsts _o_) {
/* 52 */     if (_o_ == this) return 0;
/* 53 */     int _c_ = 0;
/* 54 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\JiuXiaoConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */