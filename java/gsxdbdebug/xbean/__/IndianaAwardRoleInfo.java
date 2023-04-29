/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class IndianaAwardRoleInfo extends XBean implements xbean.IndianaAwardRoleInfo
/*     */ {
/*     */   private long roleid;
/*     */   private String role_name;
/*     */   private int award_state;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.roleid = 0L;
/*  23 */     this.role_name = "";
/*  24 */     this.award_state = 0;
/*     */   }
/*     */   
/*     */   IndianaAwardRoleInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.roleid = 0L;
/*  31 */     this.role_name = "";
/*  32 */     this.award_state = 0;
/*     */   }
/*     */   
/*     */   public IndianaAwardRoleInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public IndianaAwardRoleInfo(IndianaAwardRoleInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   IndianaAwardRoleInfo(xbean.IndianaAwardRoleInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof IndianaAwardRoleInfo)) { assign((IndianaAwardRoleInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(IndianaAwardRoleInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.roleid = _o_.roleid;
/*  58 */     this.role_name = _o_.role_name;
/*  59 */     this.award_state = _o_.award_state;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.roleid = _o_.roleid;
/*  65 */     this.role_name = _o_.role_name;
/*  66 */     this.award_state = _o_.award_state;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.roleid);
/*  74 */     _os_.marshal(this.role_name, "UTF-16LE");
/*  75 */     _os_.marshal(this.award_state);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.roleid = _os_.unmarshal_long();
/*  84 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  85 */     this.award_state = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*     */     try
/*     */     {
/*  97 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 101 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(3, this.award_state);
/* 104 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       _output_.writeInt64(1, this.roleid);
/* 114 */       _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/* 115 */       _output_.writeInt32(3, this.award_state);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.roleid = _input_.readInt64();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 148 */           this.role_name = _input_.readBytes().toString("UTF-16LE");
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 153 */           this.award_state = _input_.readInt32();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 158 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 160 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 169 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IndianaAwardRoleInfo copy()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new IndianaAwardRoleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IndianaAwardRoleInfo toData()
/*     */   {
/* 188 */     _xdb_verify_unsafe_();
/* 189 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IndianaAwardRoleInfo toBean()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new IndianaAwardRoleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.IndianaAwardRoleInfo toDataIf()
/*     */   {
/* 201 */     _xdb_verify_unsafe_();
/* 202 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.IndianaAwardRoleInfo toBeanIf()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRole_name()
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     return this.role_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getRole_nameOctets()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return Octets.wrap(getRole_name(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAward_state()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return this.award_state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 259 */         new xdb.logs.LogLong(this, IndianaAwardRoleInfo.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 263 */             IndianaAwardRoleInfo.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 267 */     });
/* 268 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_name(String _v_)
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     if (null == _v_)
/* 277 */       throw new NullPointerException();
/* 278 */     xdb.Logs.logIf(new LogKey(this, "role_name")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 282 */         new xdb.logs.LogString(this, IndianaAwardRoleInfo.this.role_name)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 286 */             IndianaAwardRoleInfo.this.role_name = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 290 */     });
/* 291 */     this.role_name = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_nameOctets(Octets _v_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     setRole_name(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_state(int _v_)
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     xdb.Logs.logIf(new LogKey(this, "award_state")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 311 */         new xdb.logs.LogInt(this, IndianaAwardRoleInfo.this.award_state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 315 */             IndianaAwardRoleInfo.this.award_state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 319 */     });
/* 320 */     this.award_state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     IndianaAwardRoleInfo _o_ = null;
/* 328 */     if ((_o1_ instanceof IndianaAwardRoleInfo)) { _o_ = (IndianaAwardRoleInfo)_o1_;
/* 329 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 330 */       return false;
/* 331 */     if (this.roleid != _o_.roleid) return false;
/* 332 */     if (!this.role_name.equals(_o_.role_name)) return false;
/* 333 */     if (this.award_state != _o_.award_state) return false;
/* 334 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 340 */     _xdb_verify_unsafe_();
/* 341 */     int _h_ = 0;
/* 342 */     _h_ = (int)(_h_ + this.roleid);
/* 343 */     _h_ += this.role_name.hashCode();
/* 344 */     _h_ += this.award_state;
/* 345 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     StringBuilder _sb_ = new StringBuilder();
/* 353 */     _sb_.append("(");
/* 354 */     _sb_.append(this.roleid);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append("'").append(this.role_name).append("'");
/* 357 */     _sb_.append(",");
/* 358 */     _sb_.append(this.award_state);
/* 359 */     _sb_.append(")");
/* 360 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 366 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 367 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 368 */     lb.add(new ListenableChanged().setVarName("role_name"));
/* 369 */     lb.add(new ListenableChanged().setVarName("award_state"));
/* 370 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.IndianaAwardRoleInfo {
/*     */     private Const() {}
/*     */     
/*     */     IndianaAwardRoleInfo nThis() {
/* 377 */       return IndianaAwardRoleInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 383 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IndianaAwardRoleInfo copy()
/*     */     {
/* 389 */       return IndianaAwardRoleInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IndianaAwardRoleInfo toData()
/*     */     {
/* 395 */       return IndianaAwardRoleInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.IndianaAwardRoleInfo toBean()
/*     */     {
/* 400 */       return IndianaAwardRoleInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IndianaAwardRoleInfo toDataIf()
/*     */     {
/* 406 */       return IndianaAwardRoleInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.IndianaAwardRoleInfo toBeanIf()
/*     */     {
/* 411 */       return IndianaAwardRoleInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 418 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 419 */       return IndianaAwardRoleInfo.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRole_name()
/*     */     {
/* 426 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 427 */       return IndianaAwardRoleInfo.this.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRole_nameOctets()
/*     */     {
/* 434 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 435 */       return IndianaAwardRoleInfo.this.getRole_nameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_state()
/*     */     {
/* 442 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 443 */       return IndianaAwardRoleInfo.this.award_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 450 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_name(String _v_)
/*     */     {
/* 458 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 459 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_nameOctets(Octets _v_)
/*     */     {
/* 466 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_state(int _v_)
/*     */     {
/* 474 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 481 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 482 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 488 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 489 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 495 */       return IndianaAwardRoleInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 501 */       return IndianaAwardRoleInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 507 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 508 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 514 */       return IndianaAwardRoleInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       return IndianaAwardRoleInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 526 */       IndianaAwardRoleInfo.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 533 */       return IndianaAwardRoleInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 539 */       return IndianaAwardRoleInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 545 */       return IndianaAwardRoleInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 551 */       return IndianaAwardRoleInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 557 */       return IndianaAwardRoleInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 563 */       return IndianaAwardRoleInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 569 */       return IndianaAwardRoleInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.IndianaAwardRoleInfo
/*     */   {
/*     */     private long roleid;
/*     */     
/*     */     private String role_name;
/*     */     
/*     */     private int award_state;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 590 */       this.roleid = 0L;
/* 591 */       this.role_name = "";
/* 592 */       this.award_state = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.IndianaAwardRoleInfo _o1_)
/*     */     {
/* 597 */       if ((_o1_ instanceof IndianaAwardRoleInfo)) { assign((IndianaAwardRoleInfo)_o1_);
/* 598 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 599 */       } else if ((_o1_ instanceof IndianaAwardRoleInfo.Const)) assign(((IndianaAwardRoleInfo.Const)_o1_).nThis()); else {
/* 600 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(IndianaAwardRoleInfo _o_) {
/* 605 */       this.roleid = _o_.roleid;
/* 606 */       this.role_name = _o_.role_name;
/* 607 */       this.award_state = _o_.award_state;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 612 */       this.roleid = _o_.roleid;
/* 613 */       this.role_name = _o_.role_name;
/* 614 */       this.award_state = _o_.award_state;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 620 */       _os_.marshal(this.roleid);
/* 621 */       _os_.marshal(this.role_name, "UTF-16LE");
/* 622 */       _os_.marshal(this.award_state);
/* 623 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 629 */       this.roleid = _os_.unmarshal_long();
/* 630 */       this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 631 */       this.award_state = _os_.unmarshal_int();
/* 632 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 638 */       int _size_ = 0;
/* 639 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*     */       try
/*     */       {
/* 642 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 646 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 648 */       _size_ += CodedOutputStream.computeInt32Size(3, this.award_state);
/* 649 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 657 */         _output_.writeInt64(1, this.roleid);
/* 658 */         _output_.writeBytes(2, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/* 659 */         _output_.writeInt32(3, this.award_state);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 663 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 665 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 673 */         boolean done = false;
/* 674 */         while (!done)
/*     */         {
/* 676 */           int tag = _input_.readTag();
/* 677 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 681 */             done = true;
/* 682 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 686 */             this.roleid = _input_.readInt64();
/* 687 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 691 */             this.role_name = _input_.readBytes().toString("UTF-16LE");
/* 692 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 696 */             this.award_state = _input_.readInt32();
/* 697 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 701 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 703 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 712 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 716 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 718 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IndianaAwardRoleInfo copy()
/*     */     {
/* 724 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IndianaAwardRoleInfo toData()
/*     */     {
/* 730 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.IndianaAwardRoleInfo toBean()
/*     */     {
/* 735 */       return new IndianaAwardRoleInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.IndianaAwardRoleInfo toDataIf()
/*     */     {
/* 741 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.IndianaAwardRoleInfo toBeanIf()
/*     */     {
/* 746 */       return new IndianaAwardRoleInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 752 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 756 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 760 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 764 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 768 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 772 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 776 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 783 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRole_name()
/*     */     {
/* 790 */       return this.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRole_nameOctets()
/*     */     {
/* 797 */       return Octets.wrap(getRole_name(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_state()
/*     */     {
/* 804 */       return this.award_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 811 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_name(String _v_)
/*     */     {
/* 818 */       if (null == _v_)
/* 819 */         throw new NullPointerException();
/* 820 */       this.role_name = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_nameOctets(Octets _v_)
/*     */     {
/* 827 */       setRole_name(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_state(int _v_)
/*     */     {
/* 834 */       this.award_state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 840 */       if (!(_o1_ instanceof Data)) return false;
/* 841 */       Data _o_ = (Data)_o1_;
/* 842 */       if (this.roleid != _o_.roleid) return false;
/* 843 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 844 */       if (this.award_state != _o_.award_state) return false;
/* 845 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 851 */       int _h_ = 0;
/* 852 */       _h_ = (int)(_h_ + this.roleid);
/* 853 */       _h_ += this.role_name.hashCode();
/* 854 */       _h_ += this.award_state;
/* 855 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 861 */       StringBuilder _sb_ = new StringBuilder();
/* 862 */       _sb_.append("(");
/* 863 */       _sb_.append(this.roleid);
/* 864 */       _sb_.append(",");
/* 865 */       _sb_.append("'").append(this.role_name).append("'");
/* 866 */       _sb_.append(",");
/* 867 */       _sb_.append(this.award_state);
/* 868 */       _sb_.append(")");
/* 869 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */