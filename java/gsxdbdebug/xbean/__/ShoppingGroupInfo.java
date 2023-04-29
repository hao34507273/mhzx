/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class ShoppingGroupInfo extends XBean implements xbean.ShoppingGroupInfo
/*      */ {
/*      */   private int group_shopping_item_cfgid;
/*      */   private long creator_roleid;
/*      */   private int create_time;
/*      */   private int close_time;
/*      */   private int status;
/*      */   private int price;
/*      */   private int group_size;
/*      */   private SetX<Long> members;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.group_shopping_item_cfgid = 0;
/*   33 */     this.creator_roleid = 0L;
/*   34 */     this.create_time = 0;
/*   35 */     this.close_time = 0;
/*   36 */     this.status = 0;
/*   37 */     this.price = 0;
/*   38 */     this.group_size = 0;
/*   39 */     this.members.clear();
/*      */   }
/*      */   
/*      */   ShoppingGroupInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.members = new SetX();
/*      */   }
/*      */   
/*      */   public ShoppingGroupInfo()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ShoppingGroupInfo(ShoppingGroupInfo _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ShoppingGroupInfo(xbean.ShoppingGroupInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof ShoppingGroupInfo)) { assign((ShoppingGroupInfo)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ShoppingGroupInfo _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.group_shopping_item_cfgid = _o_.group_shopping_item_cfgid;
/*   71 */     this.creator_roleid = _o_.creator_roleid;
/*   72 */     this.create_time = _o_.create_time;
/*   73 */     this.close_time = _o_.close_time;
/*   74 */     this.status = _o_.status;
/*   75 */     this.price = _o_.price;
/*   76 */     this.group_size = _o_.group_size;
/*   77 */     this.members = new SetX();
/*   78 */     this.members.addAll(_o_.members);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   83 */     this.group_shopping_item_cfgid = _o_.group_shopping_item_cfgid;
/*   84 */     this.creator_roleid = _o_.creator_roleid;
/*   85 */     this.create_time = _o_.create_time;
/*   86 */     this.close_time = _o_.close_time;
/*   87 */     this.status = _o_.status;
/*   88 */     this.price = _o_.price;
/*   89 */     this.group_size = _o_.group_size;
/*   90 */     this.members = new SetX();
/*   91 */     this.members.addAll(_o_.members);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   97 */     _xdb_verify_unsafe_();
/*   98 */     _os_.marshal(this.group_shopping_item_cfgid);
/*   99 */     _os_.marshal(this.creator_roleid);
/*  100 */     _os_.marshal(this.create_time);
/*  101 */     _os_.marshal(this.close_time);
/*  102 */     _os_.marshal(this.status);
/*  103 */     _os_.marshal(this.price);
/*  104 */     _os_.marshal(this.group_size);
/*  105 */     _os_.compact_uint32(this.members.size());
/*  106 */     for (Long _v_ : this.members)
/*      */     {
/*  108 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  118 */     this.creator_roleid = _os_.unmarshal_long();
/*  119 */     this.create_time = _os_.unmarshal_int();
/*  120 */     this.close_time = _os_.unmarshal_int();
/*  121 */     this.status = _os_.unmarshal_int();
/*  122 */     this.price = _os_.unmarshal_int();
/*  123 */     this.group_size = _os_.unmarshal_int();
/*  124 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  126 */       long _v_ = 0L;
/*  127 */       _v_ = _os_.unmarshal_long();
/*  128 */       this.members.add(Long.valueOf(_v_));
/*      */     }
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     int _size_ = 0;
/*  138 */     _size_ += CodedOutputStream.computeInt32Size(1, this.group_shopping_item_cfgid);
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(2, this.creator_roleid);
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(3, this.create_time);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(4, this.close_time);
/*  142 */     _size_ += CodedOutputStream.computeInt32Size(5, this.status);
/*  143 */     _size_ += CodedOutputStream.computeInt32Size(6, this.price);
/*  144 */     _size_ += CodedOutputStream.computeInt32Size(7, this.group_size);
/*  145 */     for (Long _v_ : this.members)
/*      */     {
/*  147 */       _size_ += CodedOutputStream.computeInt64Size(8, _v_.longValue());
/*      */     }
/*  149 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  155 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  158 */       _output_.writeInt32(1, this.group_shopping_item_cfgid);
/*  159 */       _output_.writeInt64(2, this.creator_roleid);
/*  160 */       _output_.writeInt32(3, this.create_time);
/*  161 */       _output_.writeInt32(4, this.close_time);
/*  162 */       _output_.writeInt32(5, this.status);
/*  163 */       _output_.writeInt32(6, this.price);
/*  164 */       _output_.writeInt32(7, this.group_size);
/*  165 */       for (Long _v_ : this.members)
/*      */       {
/*  167 */         _output_.writeInt64(8, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  172 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  174 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       boolean done = false;
/*  184 */       while (!done)
/*      */       {
/*  186 */         int tag = _input_.readTag();
/*  187 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  191 */           done = true;
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  196 */           this.group_shopping_item_cfgid = _input_.readInt32();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  201 */           this.creator_roleid = _input_.readInt64();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  206 */           this.create_time = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  211 */           this.close_time = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  216 */           this.status = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  221 */           this.price = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  226 */           this.group_size = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  231 */           long _v_ = 0L;
/*  232 */           _v_ = _input_.readInt64();
/*  233 */           this.members.add(Long.valueOf(_v_));
/*  234 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  238 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  240 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  249 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  253 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  255 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ShoppingGroupInfo copy()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new ShoppingGroupInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ShoppingGroupInfo toData()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ShoppingGroupInfo toBean()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new ShoppingGroupInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ShoppingGroupInfo toDataIf()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ShoppingGroupInfo toBeanIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGroup_shopping_item_cfgid()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.group_shopping_item_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreator_roleid()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.creator_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCreate_time()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.create_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getClose_time()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.close_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatus()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPrice()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGroup_size()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.group_size;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getMembers()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return Logs.logSet(new LogKey(this, "members"), this.members);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getMembersAsData()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*      */     
/*  367 */     ShoppingGroupInfo _o_ = this;
/*  368 */     Set<Long> members = new SetX();
/*  369 */     members.addAll(_o_.members);
/*  370 */     return members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroup_shopping_item_cfgid(int _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     Logs.logIf(new LogKey(this, "group_shopping_item_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  382 */         new LogInt(this, ShoppingGroupInfo.this.group_shopping_item_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             ShoppingGroupInfo.this.group_shopping_item_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.group_shopping_item_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreator_roleid(long _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     Logs.logIf(new LogKey(this, "creator_roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  403 */         new xdb.logs.LogLong(this, ShoppingGroupInfo.this.creator_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             ShoppingGroupInfo.this.creator_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.creator_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreate_time(int _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     Logs.logIf(new LogKey(this, "create_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  424 */         new LogInt(this, ShoppingGroupInfo.this.create_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             ShoppingGroupInfo.this.create_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.create_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setClose_time(int _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     Logs.logIf(new LogKey(this, "close_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  445 */         new LogInt(this, ShoppingGroupInfo.this.close_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             ShoppingGroupInfo.this.close_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.close_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  466 */         new LogInt(this, ShoppingGroupInfo.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  470 */             ShoppingGroupInfo.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  474 */     });
/*  475 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPrice(int _v_)
/*      */   {
/*  482 */     _xdb_verify_unsafe_();
/*  483 */     Logs.logIf(new LogKey(this, "price")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  487 */         new LogInt(this, ShoppingGroupInfo.this.price)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  491 */             ShoppingGroupInfo.this.price = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  495 */     });
/*  496 */     this.price = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroup_size(int _v_)
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     Logs.logIf(new LogKey(this, "group_size")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  508 */         new LogInt(this, ShoppingGroupInfo.this.group_size)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  512 */             ShoppingGroupInfo.this.group_size = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  516 */     });
/*  517 */     this.group_size = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  523 */     _xdb_verify_unsafe_();
/*  524 */     ShoppingGroupInfo _o_ = null;
/*  525 */     if ((_o1_ instanceof ShoppingGroupInfo)) { _o_ = (ShoppingGroupInfo)_o1_;
/*  526 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  527 */       return false;
/*  528 */     if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  529 */     if (this.creator_roleid != _o_.creator_roleid) return false;
/*  530 */     if (this.create_time != _o_.create_time) return false;
/*  531 */     if (this.close_time != _o_.close_time) return false;
/*  532 */     if (this.status != _o_.status) return false;
/*  533 */     if (this.price != _o_.price) return false;
/*  534 */     if (this.group_size != _o_.group_size) return false;
/*  535 */     if (!this.members.equals(_o_.members)) return false;
/*  536 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  542 */     _xdb_verify_unsafe_();
/*  543 */     int _h_ = 0;
/*  544 */     _h_ += this.group_shopping_item_cfgid;
/*  545 */     _h_ = (int)(_h_ + this.creator_roleid);
/*  546 */     _h_ += this.create_time;
/*  547 */     _h_ += this.close_time;
/*  548 */     _h_ += this.status;
/*  549 */     _h_ += this.price;
/*  550 */     _h_ += this.group_size;
/*  551 */     _h_ += this.members.hashCode();
/*  552 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     StringBuilder _sb_ = new StringBuilder();
/*  560 */     _sb_.append("(");
/*  561 */     _sb_.append(this.group_shopping_item_cfgid);
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append(this.creator_roleid);
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.create_time);
/*  566 */     _sb_.append(",");
/*  567 */     _sb_.append(this.close_time);
/*  568 */     _sb_.append(",");
/*  569 */     _sb_.append(this.status);
/*  570 */     _sb_.append(",");
/*  571 */     _sb_.append(this.price);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.group_size);
/*  574 */     _sb_.append(",");
/*  575 */     _sb_.append(this.members);
/*  576 */     _sb_.append(")");
/*  577 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  583 */     ListenableBean lb = new ListenableBean();
/*  584 */     lb.add(new ListenableChanged().setVarName("group_shopping_item_cfgid"));
/*  585 */     lb.add(new ListenableChanged().setVarName("creator_roleid"));
/*  586 */     lb.add(new ListenableChanged().setVarName("create_time"));
/*  587 */     lb.add(new ListenableChanged().setVarName("close_time"));
/*  588 */     lb.add(new ListenableChanged().setVarName("status"));
/*  589 */     lb.add(new ListenableChanged().setVarName("price"));
/*  590 */     lb.add(new ListenableChanged().setVarName("group_size"));
/*  591 */     lb.add(new xdb.logs.ListenableSet().setVarName("members"));
/*  592 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ShoppingGroupInfo {
/*      */     private Const() {}
/*      */     
/*      */     ShoppingGroupInfo nThis() {
/*  599 */       return ShoppingGroupInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShoppingGroupInfo copy()
/*      */     {
/*  611 */       return ShoppingGroupInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShoppingGroupInfo toData()
/*      */     {
/*  617 */       return ShoppingGroupInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ShoppingGroupInfo toBean()
/*      */     {
/*  622 */       return ShoppingGroupInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShoppingGroupInfo toDataIf()
/*      */     {
/*  628 */       return ShoppingGroupInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ShoppingGroupInfo toBeanIf()
/*      */     {
/*  633 */       return ShoppingGroupInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroup_shopping_item_cfgid()
/*      */     {
/*  640 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  641 */       return ShoppingGroupInfo.this.group_shopping_item_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreator_roleid()
/*      */     {
/*  648 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  649 */       return ShoppingGroupInfo.this.creator_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCreate_time()
/*      */     {
/*  656 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  657 */       return ShoppingGroupInfo.this.create_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getClose_time()
/*      */     {
/*  664 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  665 */       return ShoppingGroupInfo.this.close_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  672 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  673 */       return ShoppingGroupInfo.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/*  680 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  681 */       return ShoppingGroupInfo.this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroup_size()
/*      */     {
/*  688 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  689 */       return ShoppingGroupInfo.this.group_size;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMembers()
/*      */     {
/*  696 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  697 */       return xdb.Consts.constSet(ShoppingGroupInfo.this.members);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getMembersAsData()
/*      */     {
/*  703 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*      */       
/*  705 */       ShoppingGroupInfo _o_ = ShoppingGroupInfo.this;
/*  706 */       Set<Long> members = new SetX();
/*  707 */       members.addAll(_o_.members);
/*  708 */       return members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_shopping_item_cfgid(int _v_)
/*      */     {
/*  715 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  716 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreator_roleid(long _v_)
/*      */     {
/*  723 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  724 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_time(int _v_)
/*      */     {
/*  731 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  732 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setClose_time(int _v_)
/*      */     {
/*  739 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  747 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  748 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/*  755 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  756 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_size(int _v_)
/*      */     {
/*  763 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  764 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  770 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  771 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  777 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  778 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  784 */       return ShoppingGroupInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  790 */       return ShoppingGroupInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  796 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  797 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  803 */       return ShoppingGroupInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  809 */       return ShoppingGroupInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  815 */       ShoppingGroupInfo.this._xdb_verify_unsafe_();
/*  816 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  822 */       return ShoppingGroupInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  828 */       return ShoppingGroupInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  834 */       return ShoppingGroupInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  840 */       return ShoppingGroupInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  846 */       return ShoppingGroupInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  852 */       return ShoppingGroupInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  858 */       return ShoppingGroupInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ShoppingGroupInfo
/*      */   {
/*      */     private int group_shopping_item_cfgid;
/*      */     
/*      */     private long creator_roleid;
/*      */     
/*      */     private int create_time;
/*      */     
/*      */     private int close_time;
/*      */     
/*      */     private int status;
/*      */     
/*      */     private int price;
/*      */     
/*      */     private int group_size;
/*      */     
/*      */     private HashSet<Long> members;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  884 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  889 */       this.members = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.ShoppingGroupInfo _o1_)
/*      */     {
/*  894 */       if ((_o1_ instanceof ShoppingGroupInfo)) { assign((ShoppingGroupInfo)_o1_);
/*  895 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  896 */       } else if ((_o1_ instanceof ShoppingGroupInfo.Const)) assign(((ShoppingGroupInfo.Const)_o1_).nThis()); else {
/*  897 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ShoppingGroupInfo _o_) {
/*  902 */       this.group_shopping_item_cfgid = _o_.group_shopping_item_cfgid;
/*  903 */       this.creator_roleid = _o_.creator_roleid;
/*  904 */       this.create_time = _o_.create_time;
/*  905 */       this.close_time = _o_.close_time;
/*  906 */       this.status = _o_.status;
/*  907 */       this.price = _o_.price;
/*  908 */       this.group_size = _o_.group_size;
/*  909 */       this.members = new HashSet();
/*  910 */       this.members.addAll(_o_.members);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  915 */       this.group_shopping_item_cfgid = _o_.group_shopping_item_cfgid;
/*  916 */       this.creator_roleid = _o_.creator_roleid;
/*  917 */       this.create_time = _o_.create_time;
/*  918 */       this.close_time = _o_.close_time;
/*  919 */       this.status = _o_.status;
/*  920 */       this.price = _o_.price;
/*  921 */       this.group_size = _o_.group_size;
/*  922 */       this.members = new HashSet();
/*  923 */       this.members.addAll(_o_.members);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  929 */       _os_.marshal(this.group_shopping_item_cfgid);
/*  930 */       _os_.marshal(this.creator_roleid);
/*  931 */       _os_.marshal(this.create_time);
/*  932 */       _os_.marshal(this.close_time);
/*  933 */       _os_.marshal(this.status);
/*  934 */       _os_.marshal(this.price);
/*  935 */       _os_.marshal(this.group_size);
/*  936 */       _os_.compact_uint32(this.members.size());
/*  937 */       for (Long _v_ : this.members)
/*      */       {
/*  939 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  941 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  947 */       this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  948 */       this.creator_roleid = _os_.unmarshal_long();
/*  949 */       this.create_time = _os_.unmarshal_int();
/*  950 */       this.close_time = _os_.unmarshal_int();
/*  951 */       this.status = _os_.unmarshal_int();
/*  952 */       this.price = _os_.unmarshal_int();
/*  953 */       this.group_size = _os_.unmarshal_int();
/*  954 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  956 */         long _v_ = 0L;
/*  957 */         _v_ = _os_.unmarshal_long();
/*  958 */         this.members.add(Long.valueOf(_v_));
/*      */       }
/*  960 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  966 */       int _size_ = 0;
/*  967 */       _size_ += CodedOutputStream.computeInt32Size(1, this.group_shopping_item_cfgid);
/*  968 */       _size_ += CodedOutputStream.computeInt64Size(2, this.creator_roleid);
/*  969 */       _size_ += CodedOutputStream.computeInt32Size(3, this.create_time);
/*  970 */       _size_ += CodedOutputStream.computeInt32Size(4, this.close_time);
/*  971 */       _size_ += CodedOutputStream.computeInt32Size(5, this.status);
/*  972 */       _size_ += CodedOutputStream.computeInt32Size(6, this.price);
/*  973 */       _size_ += CodedOutputStream.computeInt32Size(7, this.group_size);
/*  974 */       for (Long _v_ : this.members)
/*      */       {
/*  976 */         _size_ += CodedOutputStream.computeInt64Size(8, _v_.longValue());
/*      */       }
/*  978 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  986 */         _output_.writeInt32(1, this.group_shopping_item_cfgid);
/*  987 */         _output_.writeInt64(2, this.creator_roleid);
/*  988 */         _output_.writeInt32(3, this.create_time);
/*  989 */         _output_.writeInt32(4, this.close_time);
/*  990 */         _output_.writeInt32(5, this.status);
/*  991 */         _output_.writeInt32(6, this.price);
/*  992 */         _output_.writeInt32(7, this.group_size);
/*  993 */         for (Long _v_ : this.members)
/*      */         {
/*  995 */           _output_.writeInt64(8, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1000 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1002 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1010 */         boolean done = false;
/* 1011 */         while (!done)
/*      */         {
/* 1013 */           int tag = _input_.readTag();
/* 1014 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1018 */             done = true;
/* 1019 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1023 */             this.group_shopping_item_cfgid = _input_.readInt32();
/* 1024 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1028 */             this.creator_roleid = _input_.readInt64();
/* 1029 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1033 */             this.create_time = _input_.readInt32();
/* 1034 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1038 */             this.close_time = _input_.readInt32();
/* 1039 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1043 */             this.status = _input_.readInt32();
/* 1044 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1048 */             this.price = _input_.readInt32();
/* 1049 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1053 */             this.group_size = _input_.readInt32();
/* 1054 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1058 */             long _v_ = 0L;
/* 1059 */             _v_ = _input_.readInt64();
/* 1060 */             this.members.add(Long.valueOf(_v_));
/* 1061 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1065 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1067 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1076 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1080 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1082 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShoppingGroupInfo copy()
/*      */     {
/* 1088 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShoppingGroupInfo toData()
/*      */     {
/* 1094 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ShoppingGroupInfo toBean()
/*      */     {
/* 1099 */       return new ShoppingGroupInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ShoppingGroupInfo toDataIf()
/*      */     {
/* 1105 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ShoppingGroupInfo toBeanIf()
/*      */     {
/* 1110 */       return new ShoppingGroupInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1116 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1120 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1124 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1128 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1136 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1140 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroup_shopping_item_cfgid()
/*      */     {
/* 1147 */       return this.group_shopping_item_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreator_roleid()
/*      */     {
/* 1154 */       return this.creator_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCreate_time()
/*      */     {
/* 1161 */       return this.create_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getClose_time()
/*      */     {
/* 1168 */       return this.close_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/* 1175 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/* 1182 */       return this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGroup_size()
/*      */     {
/* 1189 */       return this.group_size;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMembers()
/*      */     {
/* 1196 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getMembersAsData()
/*      */     {
/* 1203 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_shopping_item_cfgid(int _v_)
/*      */     {
/* 1210 */       this.group_shopping_item_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreator_roleid(long _v_)
/*      */     {
/* 1217 */       this.creator_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_time(int _v_)
/*      */     {
/* 1224 */       this.create_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setClose_time(int _v_)
/*      */     {
/* 1231 */       this.close_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1238 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/* 1245 */       this.price = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroup_size(int _v_)
/*      */     {
/* 1252 */       this.group_size = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1258 */       if (!(_o1_ instanceof Data)) return false;
/* 1259 */       Data _o_ = (Data)_o1_;
/* 1260 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/* 1261 */       if (this.creator_roleid != _o_.creator_roleid) return false;
/* 1262 */       if (this.create_time != _o_.create_time) return false;
/* 1263 */       if (this.close_time != _o_.close_time) return false;
/* 1264 */       if (this.status != _o_.status) return false;
/* 1265 */       if (this.price != _o_.price) return false;
/* 1266 */       if (this.group_size != _o_.group_size) return false;
/* 1267 */       if (!this.members.equals(_o_.members)) return false;
/* 1268 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1274 */       int _h_ = 0;
/* 1275 */       _h_ += this.group_shopping_item_cfgid;
/* 1276 */       _h_ = (int)(_h_ + this.creator_roleid);
/* 1277 */       _h_ += this.create_time;
/* 1278 */       _h_ += this.close_time;
/* 1279 */       _h_ += this.status;
/* 1280 */       _h_ += this.price;
/* 1281 */       _h_ += this.group_size;
/* 1282 */       _h_ += this.members.hashCode();
/* 1283 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1289 */       StringBuilder _sb_ = new StringBuilder();
/* 1290 */       _sb_.append("(");
/* 1291 */       _sb_.append(this.group_shopping_item_cfgid);
/* 1292 */       _sb_.append(",");
/* 1293 */       _sb_.append(this.creator_roleid);
/* 1294 */       _sb_.append(",");
/* 1295 */       _sb_.append(this.create_time);
/* 1296 */       _sb_.append(",");
/* 1297 */       _sb_.append(this.close_time);
/* 1298 */       _sb_.append(",");
/* 1299 */       _sb_.append(this.status);
/* 1300 */       _sb_.append(",");
/* 1301 */       _sb_.append(this.price);
/* 1302 */       _sb_.append(",");
/* 1303 */       _sb_.append(this.group_size);
/* 1304 */       _sb_.append(",");
/* 1305 */       _sb_.append(this.members);
/* 1306 */       _sb_.append(")");
/* 1307 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ShoppingGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */