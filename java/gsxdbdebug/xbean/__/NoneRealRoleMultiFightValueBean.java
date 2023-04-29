/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class NoneRealRoleMultiFightValueBean extends XBean implements xbean.NoneRealRoleMultiFightValueBean
/*     */ {
/*     */   private long roleid;
/*     */   private int multifightvalue;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.roleid = 0L;
/*  21 */     this.multifightvalue = 0;
/*     */   }
/*     */   
/*     */   NoneRealRoleMultiFightValueBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public NoneRealRoleMultiFightValueBean()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public NoneRealRoleMultiFightValueBean(NoneRealRoleMultiFightValueBean _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   NoneRealRoleMultiFightValueBean(xbean.NoneRealRoleMultiFightValueBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof NoneRealRoleMultiFightValueBean)) { assign((NoneRealRoleMultiFightValueBean)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(NoneRealRoleMultiFightValueBean _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.roleid = _o_.roleid;
/*  52 */     this.multifightvalue = _o_.multifightvalue;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.roleid = _o_.roleid;
/*  58 */     this.multifightvalue = _o_.multifightvalue;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.roleid);
/*  66 */     _os_.marshal(this.multifightvalue);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.roleid = _os_.unmarshal_long();
/*  75 */     this.multifightvalue = _os_.unmarshal_int();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(2, this.multifightvalue);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt64(1, this.roleid);
/*  96 */       _output_.writeInt32(2, this.multifightvalue);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.roleid = _input_.readInt64();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.multifightvalue = _input_.readInt32();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealRoleMultiFightValueBean copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new NoneRealRoleMultiFightValueBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealRoleMultiFightValueBean toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NoneRealRoleMultiFightValueBean toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new NoneRealRoleMultiFightValueBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealRoleMultiFightValueBean toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NoneRealRoleMultiFightValueBean toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMultifightvalue()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.multifightvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogLong(this, NoneRealRoleMultiFightValueBean.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             NoneRealRoleMultiFightValueBean.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMultifightvalue(int _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "multifightvalue")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogInt(this, NoneRealRoleMultiFightValueBean.this.multifightvalue)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             NoneRealRoleMultiFightValueBean.this.multifightvalue = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.multifightvalue = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     NoneRealRoleMultiFightValueBean _o_ = null;
/* 257 */     if ((_o1_ instanceof NoneRealRoleMultiFightValueBean)) { _o_ = (NoneRealRoleMultiFightValueBean)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.roleid != _o_.roleid) return false;
/* 261 */     if (this.multifightvalue != _o_.multifightvalue) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ = (int)(_h_ + this.roleid);
/* 271 */     _h_ += this.multifightvalue;
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.roleid);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.multifightvalue);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleid"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("multifightvalue"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.NoneRealRoleMultiFightValueBean {
/*     */     private Const() {}
/*     */     
/*     */     NoneRealRoleMultiFightValueBean nThis() {
/* 301 */       return NoneRealRoleMultiFightValueBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealRoleMultiFightValueBean copy()
/*     */     {
/* 313 */       return NoneRealRoleMultiFightValueBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealRoleMultiFightValueBean toData()
/*     */     {
/* 319 */       return NoneRealRoleMultiFightValueBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.NoneRealRoleMultiFightValueBean toBean()
/*     */     {
/* 324 */       return NoneRealRoleMultiFightValueBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealRoleMultiFightValueBean toDataIf()
/*     */     {
/* 330 */       return NoneRealRoleMultiFightValueBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.NoneRealRoleMultiFightValueBean toBeanIf()
/*     */     {
/* 335 */       return NoneRealRoleMultiFightValueBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 342 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 343 */       return NoneRealRoleMultiFightValueBean.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMultifightvalue()
/*     */     {
/* 350 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 351 */       return NoneRealRoleMultiFightValueBean.this.multifightvalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 358 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMultifightvalue(int _v_)
/*     */     {
/* 366 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return NoneRealRoleMultiFightValueBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return NoneRealRoleMultiFightValueBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return NoneRealRoleMultiFightValueBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return NoneRealRoleMultiFightValueBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       NoneRealRoleMultiFightValueBean.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return NoneRealRoleMultiFightValueBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return NoneRealRoleMultiFightValueBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return NoneRealRoleMultiFightValueBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return NoneRealRoleMultiFightValueBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return NoneRealRoleMultiFightValueBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return NoneRealRoleMultiFightValueBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return NoneRealRoleMultiFightValueBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.NoneRealRoleMultiFightValueBean
/*     */   {
/*     */     private long roleid;
/*     */     
/*     */     private int multifightvalue;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.NoneRealRoleMultiFightValueBean _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof NoneRealRoleMultiFightValueBean)) { assign((NoneRealRoleMultiFightValueBean)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof NoneRealRoleMultiFightValueBean.Const)) assign(((NoneRealRoleMultiFightValueBean.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(NoneRealRoleMultiFightValueBean _o_) {
/* 492 */       this.roleid = _o_.roleid;
/* 493 */       this.multifightvalue = _o_.multifightvalue;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.roleid = _o_.roleid;
/* 499 */       this.multifightvalue = _o_.multifightvalue;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.roleid);
/* 506 */       _os_.marshal(this.multifightvalue);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.roleid = _os_.unmarshal_long();
/* 514 */       this.multifightvalue = _os_.unmarshal_int();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 523 */       _size_ += CodedOutputStream.computeInt32Size(2, this.multifightvalue);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt64(1, this.roleid);
/* 533 */         _output_.writeInt32(2, this.multifightvalue);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.roleid = _input_.readInt64();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.multifightvalue = _input_.readInt32();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealRoleMultiFightValueBean copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealRoleMultiFightValueBean toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.NoneRealRoleMultiFightValueBean toBean()
/*     */     {
/* 604 */       return new NoneRealRoleMultiFightValueBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealRoleMultiFightValueBean toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.NoneRealRoleMultiFightValueBean toBeanIf()
/*     */     {
/* 615 */       return new NoneRealRoleMultiFightValueBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 652 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMultifightvalue()
/*     */     {
/* 659 */       return this.multifightvalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 666 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMultifightvalue(int _v_)
/*     */     {
/* 673 */       this.multifightvalue = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.roleid != _o_.roleid) return false;
/* 682 */       if (this.multifightvalue != _o_.multifightvalue) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ = (int)(_h_ + this.roleid);
/* 691 */       _h_ += this.multifightvalue;
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.roleid);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.multifightvalue);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\NoneRealRoleMultiFightValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */