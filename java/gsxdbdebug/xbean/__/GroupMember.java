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
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class GroupMember extends XBean implements xbean.GroupMember
/*     */ {
/*     */   private long roleid;
/*     */   private long join_time;
/*     */   private long group_basic_info_version;
/*     */   private long group_info_version;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.roleid = 0L;
/*  25 */     this.join_time = 0L;
/*  26 */     this.group_basic_info_version = -1L;
/*  27 */     this.group_info_version = -1L;
/*     */   }
/*     */   
/*     */   GroupMember(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.group_basic_info_version = -1L;
/*  34 */     this.group_info_version = -1L;
/*     */   }
/*     */   
/*     */   public GroupMember()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GroupMember(GroupMember _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GroupMember(xbean.GroupMember _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof GroupMember)) { assign((GroupMember)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GroupMember _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.roleid = _o_.roleid;
/*  60 */     this.join_time = _o_.join_time;
/*  61 */     this.group_basic_info_version = _o_.group_basic_info_version;
/*  62 */     this.group_info_version = _o_.group_info_version;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.roleid = _o_.roleid;
/*  68 */     this.join_time = _o_.join_time;
/*  69 */     this.group_basic_info_version = _o_.group_basic_info_version;
/*  70 */     this.group_info_version = _o_.group_info_version;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.roleid);
/*  78 */     _os_.marshal(this.join_time);
/*  79 */     _os_.marshal(this.group_basic_info_version);
/*  80 */     _os_.marshal(this.group_info_version);
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     this.roleid = _os_.unmarshal_long();
/*  89 */     this.join_time = _os_.unmarshal_long();
/*  90 */     this.group_basic_info_version = _os_.unmarshal_long();
/*  91 */     this.group_info_version = _os_.unmarshal_long();
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  98 */     _xdb_verify_unsafe_();
/*  99 */     int _size_ = 0;
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(2, this.join_time);
/* 102 */     _size_ += CodedOutputStream.computeInt64Size(3, this.group_basic_info_version);
/* 103 */     _size_ += CodedOutputStream.computeInt64Size(4, this.group_info_version);
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
/* 114 */       _output_.writeInt64(2, this.join_time);
/* 115 */       _output_.writeInt64(3, this.group_basic_info_version);
/* 116 */       _output_.writeInt64(4, this.group_info_version);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 144 */           this.roleid = _input_.readInt64();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 149 */           this.join_time = _input_.readInt64();
/* 150 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 154 */           this.group_basic_info_version = _input_.readInt64();
/* 155 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 159 */           this.group_info_version = _input_.readInt64();
/* 160 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 164 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 166 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 175 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 181 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupMember copy()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new GroupMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupMember toData()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GroupMember toBean()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new GroupMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GroupMember toDataIf()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GroupMember toBeanIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getJoin_time()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.join_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGroup_basic_info_version()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.group_basic_info_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGroup_info_version()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this.group_info_version;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogLong(this, GroupMember.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             GroupMember.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setJoin_time(long _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "join_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogLong(this, GroupMember.this.join_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             GroupMember.this.join_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.join_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGroup_basic_info_version(long _v_)
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     xdb.Logs.logIf(new LogKey(this, "group_basic_info_version")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 307 */         new LogLong(this, GroupMember.this.group_basic_info_version)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 311 */             GroupMember.this.group_basic_info_version = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 315 */     });
/* 316 */     this.group_basic_info_version = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGroup_info_version(long _v_)
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     xdb.Logs.logIf(new LogKey(this, "group_info_version")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 328 */         new LogLong(this, GroupMember.this.group_info_version)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 332 */             GroupMember.this.group_info_version = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 336 */     });
/* 337 */     this.group_info_version = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     GroupMember _o_ = null;
/* 345 */     if ((_o1_ instanceof GroupMember)) { _o_ = (GroupMember)_o1_;
/* 346 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 347 */       return false;
/* 348 */     if (this.roleid != _o_.roleid) return false;
/* 349 */     if (this.join_time != _o_.join_time) return false;
/* 350 */     if (this.group_basic_info_version != _o_.group_basic_info_version) return false;
/* 351 */     if (this.group_info_version != _o_.group_info_version) return false;
/* 352 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     int _h_ = 0;
/* 360 */     _h_ = (int)(_h_ + this.roleid);
/* 361 */     _h_ = (int)(_h_ + this.join_time);
/* 362 */     _h_ = (int)(_h_ + this.group_basic_info_version);
/* 363 */     _h_ = (int)(_h_ + this.group_info_version);
/* 364 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 370 */     _xdb_verify_unsafe_();
/* 371 */     StringBuilder _sb_ = new StringBuilder();
/* 372 */     _sb_.append("(");
/* 373 */     _sb_.append(this.roleid);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.join_time);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.group_basic_info_version);
/* 378 */     _sb_.append(",");
/* 379 */     _sb_.append(this.group_info_version);
/* 380 */     _sb_.append(")");
/* 381 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 387 */     ListenableBean lb = new ListenableBean();
/* 388 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 389 */     lb.add(new ListenableChanged().setVarName("join_time"));
/* 390 */     lb.add(new ListenableChanged().setVarName("group_basic_info_version"));
/* 391 */     lb.add(new ListenableChanged().setVarName("group_info_version"));
/* 392 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GroupMember {
/*     */     private Const() {}
/*     */     
/*     */     GroupMember nThis() {
/* 399 */       return GroupMember.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupMember copy()
/*     */     {
/* 411 */       return GroupMember.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupMember toData()
/*     */     {
/* 417 */       return GroupMember.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GroupMember toBean()
/*     */     {
/* 422 */       return GroupMember.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupMember toDataIf()
/*     */     {
/* 428 */       return GroupMember.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GroupMember toBeanIf()
/*     */     {
/* 433 */       return GroupMember.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 440 */       GroupMember.this._xdb_verify_unsafe_();
/* 441 */       return GroupMember.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getJoin_time()
/*     */     {
/* 448 */       GroupMember.this._xdb_verify_unsafe_();
/* 449 */       return GroupMember.this.join_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGroup_basic_info_version()
/*     */     {
/* 456 */       GroupMember.this._xdb_verify_unsafe_();
/* 457 */       return GroupMember.this.group_basic_info_version;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGroup_info_version()
/*     */     {
/* 464 */       GroupMember.this._xdb_verify_unsafe_();
/* 465 */       return GroupMember.this.group_info_version;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 472 */       GroupMember.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setJoin_time(long _v_)
/*     */     {
/* 480 */       GroupMember.this._xdb_verify_unsafe_();
/* 481 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroup_basic_info_version(long _v_)
/*     */     {
/* 488 */       GroupMember.this._xdb_verify_unsafe_();
/* 489 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroup_info_version(long _v_)
/*     */     {
/* 496 */       GroupMember.this._xdb_verify_unsafe_();
/* 497 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 503 */       GroupMember.this._xdb_verify_unsafe_();
/* 504 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 510 */       GroupMember.this._xdb_verify_unsafe_();
/* 511 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 517 */       return GroupMember.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 523 */       return GroupMember.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 529 */       GroupMember.this._xdb_verify_unsafe_();
/* 530 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 536 */       return GroupMember.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 542 */       return GroupMember.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 548 */       GroupMember.this._xdb_verify_unsafe_();
/* 549 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 555 */       return GroupMember.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 561 */       return GroupMember.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 567 */       return GroupMember.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 573 */       return GroupMember.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 579 */       return GroupMember.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 585 */       return GroupMember.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 591 */       return GroupMember.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GroupMember
/*     */   {
/*     */     private long roleid;
/*     */     
/*     */     private long join_time;
/*     */     
/*     */     private long group_basic_info_version;
/*     */     
/*     */     private long group_info_version;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 609 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 614 */       this.group_basic_info_version = -1L;
/* 615 */       this.group_info_version = -1L;
/*     */     }
/*     */     
/*     */     Data(xbean.GroupMember _o1_)
/*     */     {
/* 620 */       if ((_o1_ instanceof GroupMember)) { assign((GroupMember)_o1_);
/* 621 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 622 */       } else if ((_o1_ instanceof GroupMember.Const)) assign(((GroupMember.Const)_o1_).nThis()); else {
/* 623 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GroupMember _o_) {
/* 628 */       this.roleid = _o_.roleid;
/* 629 */       this.join_time = _o_.join_time;
/* 630 */       this.group_basic_info_version = _o_.group_basic_info_version;
/* 631 */       this.group_info_version = _o_.group_info_version;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 636 */       this.roleid = _o_.roleid;
/* 637 */       this.join_time = _o_.join_time;
/* 638 */       this.group_basic_info_version = _o_.group_basic_info_version;
/* 639 */       this.group_info_version = _o_.group_info_version;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 645 */       _os_.marshal(this.roleid);
/* 646 */       _os_.marshal(this.join_time);
/* 647 */       _os_.marshal(this.group_basic_info_version);
/* 648 */       _os_.marshal(this.group_info_version);
/* 649 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 655 */       this.roleid = _os_.unmarshal_long();
/* 656 */       this.join_time = _os_.unmarshal_long();
/* 657 */       this.group_basic_info_version = _os_.unmarshal_long();
/* 658 */       this.group_info_version = _os_.unmarshal_long();
/* 659 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 665 */       int _size_ = 0;
/* 666 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 667 */       _size_ += CodedOutputStream.computeInt64Size(2, this.join_time);
/* 668 */       _size_ += CodedOutputStream.computeInt64Size(3, this.group_basic_info_version);
/* 669 */       _size_ += CodedOutputStream.computeInt64Size(4, this.group_info_version);
/* 670 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 678 */         _output_.writeInt64(1, this.roleid);
/* 679 */         _output_.writeInt64(2, this.join_time);
/* 680 */         _output_.writeInt64(3, this.group_basic_info_version);
/* 681 */         _output_.writeInt64(4, this.group_info_version);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 685 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 687 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 695 */         boolean done = false;
/* 696 */         while (!done)
/*     */         {
/* 698 */           int tag = _input_.readTag();
/* 699 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 703 */             done = true;
/* 704 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 708 */             this.roleid = _input_.readInt64();
/* 709 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 713 */             this.join_time = _input_.readInt64();
/* 714 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 718 */             this.group_basic_info_version = _input_.readInt64();
/* 719 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 723 */             this.group_info_version = _input_.readInt64();
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupMember copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupMember toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GroupMember toBean()
/*     */     {
/* 762 */       return new GroupMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GroupMember toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GroupMember toBeanIf()
/*     */     {
/* 773 */       return new GroupMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 810 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getJoin_time()
/*     */     {
/* 817 */       return this.join_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGroup_basic_info_version()
/*     */     {
/* 824 */       return this.group_basic_info_version;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGroup_info_version()
/*     */     {
/* 831 */       return this.group_info_version;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 838 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setJoin_time(long _v_)
/*     */     {
/* 845 */       this.join_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroup_basic_info_version(long _v_)
/*     */     {
/* 852 */       this.group_basic_info_version = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroup_info_version(long _v_)
/*     */     {
/* 859 */       this.group_info_version = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 865 */       if (!(_o1_ instanceof Data)) return false;
/* 866 */       Data _o_ = (Data)_o1_;
/* 867 */       if (this.roleid != _o_.roleid) return false;
/* 868 */       if (this.join_time != _o_.join_time) return false;
/* 869 */       if (this.group_basic_info_version != _o_.group_basic_info_version) return false;
/* 870 */       if (this.group_info_version != _o_.group_info_version) return false;
/* 871 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 877 */       int _h_ = 0;
/* 878 */       _h_ = (int)(_h_ + this.roleid);
/* 879 */       _h_ = (int)(_h_ + this.join_time);
/* 880 */       _h_ = (int)(_h_ + this.group_basic_info_version);
/* 881 */       _h_ = (int)(_h_ + this.group_info_version);
/* 882 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 888 */       StringBuilder _sb_ = new StringBuilder();
/* 889 */       _sb_.append("(");
/* 890 */       _sb_.append(this.roleid);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.join_time);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.group_basic_info_version);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append(this.group_info_version);
/* 897 */       _sb_.append(")");
/* 898 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GroupMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */