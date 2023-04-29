/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class ItemInfo extends XBean implements xbean.ItemInfo
/*      */ {
/*      */   private int itemcfgid;
/*      */   private int itemnum;
/*      */   private int itemtype;
/*      */   private boolean taskstate;
/*      */   private boolean ganghelpstate;
/*      */   private boolean friendhelpstate;
/*      */   private long roleid;
/*      */   private int xiulianexp;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.itemcfgid = 0;
/*   33 */     this.itemnum = 0;
/*   34 */     this.itemtype = 0;
/*   35 */     this.taskstate = false;
/*   36 */     this.ganghelpstate = false;
/*   37 */     this.friendhelpstate = false;
/*   38 */     this.roleid = 0L;
/*   39 */     this.xiulianexp = 0;
/*      */   }
/*      */   
/*      */   ItemInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public ItemInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ItemInfo(ItemInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ItemInfo(xbean.ItemInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof ItemInfo)) { assign((ItemInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ItemInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.itemcfgid = _o_.itemcfgid;
/*   70 */     this.itemnum = _o_.itemnum;
/*   71 */     this.itemtype = _o_.itemtype;
/*   72 */     this.taskstate = _o_.taskstate;
/*   73 */     this.ganghelpstate = _o_.ganghelpstate;
/*   74 */     this.friendhelpstate = _o_.friendhelpstate;
/*   75 */     this.roleid = _o_.roleid;
/*   76 */     this.xiulianexp = _o_.xiulianexp;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.itemcfgid = _o_.itemcfgid;
/*   82 */     this.itemnum = _o_.itemnum;
/*   83 */     this.itemtype = _o_.itemtype;
/*   84 */     this.taskstate = _o_.taskstate;
/*   85 */     this.ganghelpstate = _o_.ganghelpstate;
/*   86 */     this.friendhelpstate = _o_.friendhelpstate;
/*   87 */     this.roleid = _o_.roleid;
/*   88 */     this.xiulianexp = _o_.xiulianexp;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.itemcfgid);
/*   96 */     _os_.marshal(this.itemnum);
/*   97 */     _os_.marshal(this.itemtype);
/*   98 */     _os_.marshal(this.taskstate);
/*   99 */     _os_.marshal(this.ganghelpstate);
/*  100 */     _os_.marshal(this.friendhelpstate);
/*  101 */     _os_.marshal(this.roleid);
/*  102 */     _os_.marshal(this.xiulianexp);
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*  110 */     this.itemcfgid = _os_.unmarshal_int();
/*  111 */     this.itemnum = _os_.unmarshal_int();
/*  112 */     this.itemtype = _os_.unmarshal_int();
/*  113 */     this.taskstate = _os_.unmarshal_boolean();
/*  114 */     this.ganghelpstate = _os_.unmarshal_boolean();
/*  115 */     this.friendhelpstate = _os_.unmarshal_boolean();
/*  116 */     this.roleid = _os_.unmarshal_long();
/*  117 */     this.xiulianexp = _os_.unmarshal_int();
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     int _size_ = 0;
/*  126 */     _size_ += CodedOutputStream.computeInt32Size(1, this.itemcfgid);
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(2, this.itemnum);
/*  128 */     _size_ += CodedOutputStream.computeInt32Size(3, this.itemtype);
/*  129 */     _size_ += CodedOutputStream.computeBoolSize(4, this.taskstate);
/*  130 */     _size_ += CodedOutputStream.computeBoolSize(5, this.ganghelpstate);
/*  131 */     _size_ += CodedOutputStream.computeBoolSize(6, this.friendhelpstate);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(7, this.roleid);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(8, this.xiulianexp);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeInt32(1, this.itemcfgid);
/*  144 */       _output_.writeInt32(2, this.itemnum);
/*  145 */       _output_.writeInt32(3, this.itemtype);
/*  146 */       _output_.writeBool(4, this.taskstate);
/*  147 */       _output_.writeBool(5, this.ganghelpstate);
/*  148 */       _output_.writeBool(6, this.friendhelpstate);
/*  149 */       _output_.writeInt64(7, this.roleid);
/*  150 */       _output_.writeInt32(8, this.xiulianexp);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  154 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  156 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       boolean done = false;
/*  166 */       while (!done)
/*      */       {
/*  168 */         int tag = _input_.readTag();
/*  169 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  173 */           done = true;
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  178 */           this.itemcfgid = _input_.readInt32();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  183 */           this.itemnum = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  188 */           this.itemtype = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  193 */           this.taskstate = _input_.readBool();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  198 */           this.ganghelpstate = _input_.readBool();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  203 */           this.friendhelpstate = _input_.readBool();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  208 */           this.roleid = _input_.readInt64();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  213 */           this.xiulianexp = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  218 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  220 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  229 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  233 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  235 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ItemInfo copy()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new ItemInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ItemInfo toData()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ItemInfo toBean()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new ItemInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ItemInfo toDataIf()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ItemInfo toBeanIf()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemcfgid()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this.itemcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemnum()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return this.itemnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemtype()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return this.itemtype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getTaskstate()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this.taskstate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getGanghelpstate()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this.ganghelpstate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getFriendhelpstate()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return this.friendhelpstate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getXiulianexp()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return this.xiulianexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemcfgid(int _v_)
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     Logs.logIf(new LogKey(this, "itemcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  351 */         new LogInt(this, ItemInfo.this.itemcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  355 */             ItemInfo.this.itemcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  359 */     });
/*  360 */     this.itemcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemnum(int _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     Logs.logIf(new LogKey(this, "itemnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  372 */         new LogInt(this, ItemInfo.this.itemnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             ItemInfo.this.itemnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.itemnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemtype(int _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     Logs.logIf(new LogKey(this, "itemtype")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  393 */         new LogInt(this, ItemInfo.this.itemtype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             ItemInfo.this.itemtype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.itemtype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTaskstate(boolean _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     Logs.logIf(new LogKey(this, "taskstate")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  414 */         new LogObject(this, Boolean.valueOf(ItemInfo.this.taskstate))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             ItemInfo.this.taskstate = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.taskstate = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGanghelpstate(boolean _v_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     Logs.logIf(new LogKey(this, "ganghelpstate")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  435 */         new LogObject(this, Boolean.valueOf(ItemInfo.this.ganghelpstate))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  439 */             ItemInfo.this.ganghelpstate = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  443 */     });
/*  444 */     this.ganghelpstate = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFriendhelpstate(boolean _v_)
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     Logs.logIf(new LogKey(this, "friendhelpstate")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  456 */         new LogObject(this, Boolean.valueOf(ItemInfo.this.friendhelpstate))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  460 */             ItemInfo.this.friendhelpstate = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  464 */     });
/*  465 */     this.friendhelpstate = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  477 */         new xdb.logs.LogLong(this, ItemInfo.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  481 */             ItemInfo.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  485 */     });
/*  486 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setXiulianexp(int _v_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     Logs.logIf(new LogKey(this, "xiulianexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  498 */         new LogInt(this, ItemInfo.this.xiulianexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  502 */             ItemInfo.this.xiulianexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  506 */     });
/*  507 */     this.xiulianexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     ItemInfo _o_ = null;
/*  515 */     if ((_o1_ instanceof ItemInfo)) { _o_ = (ItemInfo)_o1_;
/*  516 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  517 */       return false;
/*  518 */     if (this.itemcfgid != _o_.itemcfgid) return false;
/*  519 */     if (this.itemnum != _o_.itemnum) return false;
/*  520 */     if (this.itemtype != _o_.itemtype) return false;
/*  521 */     if (this.taskstate != _o_.taskstate) return false;
/*  522 */     if (this.ganghelpstate != _o_.ganghelpstate) return false;
/*  523 */     if (this.friendhelpstate != _o_.friendhelpstate) return false;
/*  524 */     if (this.roleid != _o_.roleid) return false;
/*  525 */     if (this.xiulianexp != _o_.xiulianexp) return false;
/*  526 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*  533 */     int _h_ = 0;
/*  534 */     _h_ += this.itemcfgid;
/*  535 */     _h_ += this.itemnum;
/*  536 */     _h_ += this.itemtype;
/*  537 */     _h_ += (this.taskstate ? 1231 : 1237);
/*  538 */     _h_ += (this.ganghelpstate ? 1231 : 1237);
/*  539 */     _h_ += (this.friendhelpstate ? 1231 : 1237);
/*  540 */     _h_ = (int)(_h_ + this.roleid);
/*  541 */     _h_ += this.xiulianexp;
/*  542 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     StringBuilder _sb_ = new StringBuilder();
/*  550 */     _sb_.append("(");
/*  551 */     _sb_.append(this.itemcfgid);
/*  552 */     _sb_.append(",");
/*  553 */     _sb_.append(this.itemnum);
/*  554 */     _sb_.append(",");
/*  555 */     _sb_.append(this.itemtype);
/*  556 */     _sb_.append(",");
/*  557 */     _sb_.append(this.taskstate);
/*  558 */     _sb_.append(",");
/*  559 */     _sb_.append(this.ganghelpstate);
/*  560 */     _sb_.append(",");
/*  561 */     _sb_.append(this.friendhelpstate);
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append(this.roleid);
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.xiulianexp);
/*  566 */     _sb_.append(")");
/*  567 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  573 */     ListenableBean lb = new ListenableBean();
/*  574 */     lb.add(new ListenableChanged().setVarName("itemcfgid"));
/*  575 */     lb.add(new ListenableChanged().setVarName("itemnum"));
/*  576 */     lb.add(new ListenableChanged().setVarName("itemtype"));
/*  577 */     lb.add(new ListenableChanged().setVarName("taskstate"));
/*  578 */     lb.add(new ListenableChanged().setVarName("ganghelpstate"));
/*  579 */     lb.add(new ListenableChanged().setVarName("friendhelpstate"));
/*  580 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  581 */     lb.add(new ListenableChanged().setVarName("xiulianexp"));
/*  582 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ItemInfo {
/*      */     private Const() {}
/*      */     
/*      */     ItemInfo nThis() {
/*  589 */       return ItemInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  595 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ItemInfo copy()
/*      */     {
/*  601 */       return ItemInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ItemInfo toData()
/*      */     {
/*  607 */       return ItemInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ItemInfo toBean()
/*      */     {
/*  612 */       return ItemInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ItemInfo toDataIf()
/*      */     {
/*  618 */       return ItemInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ItemInfo toBeanIf()
/*      */     {
/*  623 */       return ItemInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemcfgid()
/*      */     {
/*  630 */       ItemInfo.this._xdb_verify_unsafe_();
/*  631 */       return ItemInfo.this.itemcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemnum()
/*      */     {
/*  638 */       ItemInfo.this._xdb_verify_unsafe_();
/*  639 */       return ItemInfo.this.itemnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemtype()
/*      */     {
/*  646 */       ItemInfo.this._xdb_verify_unsafe_();
/*  647 */       return ItemInfo.this.itemtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getTaskstate()
/*      */     {
/*  654 */       ItemInfo.this._xdb_verify_unsafe_();
/*  655 */       return ItemInfo.this.taskstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGanghelpstate()
/*      */     {
/*  662 */       ItemInfo.this._xdb_verify_unsafe_();
/*  663 */       return ItemInfo.this.ganghelpstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getFriendhelpstate()
/*      */     {
/*  670 */       ItemInfo.this._xdb_verify_unsafe_();
/*  671 */       return ItemInfo.this.friendhelpstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  678 */       ItemInfo.this._xdb_verify_unsafe_();
/*  679 */       return ItemInfo.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getXiulianexp()
/*      */     {
/*  686 */       ItemInfo.this._xdb_verify_unsafe_();
/*  687 */       return ItemInfo.this.xiulianexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemcfgid(int _v_)
/*      */     {
/*  694 */       ItemInfo.this._xdb_verify_unsafe_();
/*  695 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemnum(int _v_)
/*      */     {
/*  702 */       ItemInfo.this._xdb_verify_unsafe_();
/*  703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemtype(int _v_)
/*      */     {
/*  710 */       ItemInfo.this._xdb_verify_unsafe_();
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTaskstate(boolean _v_)
/*      */     {
/*  718 */       ItemInfo.this._xdb_verify_unsafe_();
/*  719 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGanghelpstate(boolean _v_)
/*      */     {
/*  726 */       ItemInfo.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFriendhelpstate(boolean _v_)
/*      */     {
/*  734 */       ItemInfo.this._xdb_verify_unsafe_();
/*  735 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  742 */       ItemInfo.this._xdb_verify_unsafe_();
/*  743 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setXiulianexp(int _v_)
/*      */     {
/*  750 */       ItemInfo.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  757 */       ItemInfo.this._xdb_verify_unsafe_();
/*  758 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  764 */       ItemInfo.this._xdb_verify_unsafe_();
/*  765 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  771 */       return ItemInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       return ItemInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  783 */       ItemInfo.this._xdb_verify_unsafe_();
/*  784 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  790 */       return ItemInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  796 */       return ItemInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  802 */       ItemInfo.this._xdb_verify_unsafe_();
/*  803 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  809 */       return ItemInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  815 */       return ItemInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  821 */       return ItemInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  827 */       return ItemInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  833 */       return ItemInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  839 */       return ItemInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  845 */       return ItemInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ItemInfo
/*      */   {
/*      */     private int itemcfgid;
/*      */     
/*      */     private int itemnum;
/*      */     
/*      */     private int itemtype;
/*      */     
/*      */     private boolean taskstate;
/*      */     
/*      */     private boolean ganghelpstate;
/*      */     
/*      */     private boolean friendhelpstate;
/*      */     
/*      */     private long roleid;
/*      */     
/*      */     private int xiulianexp;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  871 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.ItemInfo _o1_)
/*      */     {
/*  880 */       if ((_o1_ instanceof ItemInfo)) { assign((ItemInfo)_o1_);
/*  881 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  882 */       } else if ((_o1_ instanceof ItemInfo.Const)) assign(((ItemInfo.Const)_o1_).nThis()); else {
/*  883 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ItemInfo _o_) {
/*  888 */       this.itemcfgid = _o_.itemcfgid;
/*  889 */       this.itemnum = _o_.itemnum;
/*  890 */       this.itemtype = _o_.itemtype;
/*  891 */       this.taskstate = _o_.taskstate;
/*  892 */       this.ganghelpstate = _o_.ganghelpstate;
/*  893 */       this.friendhelpstate = _o_.friendhelpstate;
/*  894 */       this.roleid = _o_.roleid;
/*  895 */       this.xiulianexp = _o_.xiulianexp;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  900 */       this.itemcfgid = _o_.itemcfgid;
/*  901 */       this.itemnum = _o_.itemnum;
/*  902 */       this.itemtype = _o_.itemtype;
/*  903 */       this.taskstate = _o_.taskstate;
/*  904 */       this.ganghelpstate = _o_.ganghelpstate;
/*  905 */       this.friendhelpstate = _o_.friendhelpstate;
/*  906 */       this.roleid = _o_.roleid;
/*  907 */       this.xiulianexp = _o_.xiulianexp;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  913 */       _os_.marshal(this.itemcfgid);
/*  914 */       _os_.marshal(this.itemnum);
/*  915 */       _os_.marshal(this.itemtype);
/*  916 */       _os_.marshal(this.taskstate);
/*  917 */       _os_.marshal(this.ganghelpstate);
/*  918 */       _os_.marshal(this.friendhelpstate);
/*  919 */       _os_.marshal(this.roleid);
/*  920 */       _os_.marshal(this.xiulianexp);
/*  921 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  927 */       this.itemcfgid = _os_.unmarshal_int();
/*  928 */       this.itemnum = _os_.unmarshal_int();
/*  929 */       this.itemtype = _os_.unmarshal_int();
/*  930 */       this.taskstate = _os_.unmarshal_boolean();
/*  931 */       this.ganghelpstate = _os_.unmarshal_boolean();
/*  932 */       this.friendhelpstate = _os_.unmarshal_boolean();
/*  933 */       this.roleid = _os_.unmarshal_long();
/*  934 */       this.xiulianexp = _os_.unmarshal_int();
/*  935 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  941 */       int _size_ = 0;
/*  942 */       _size_ += CodedOutputStream.computeInt32Size(1, this.itemcfgid);
/*  943 */       _size_ += CodedOutputStream.computeInt32Size(2, this.itemnum);
/*  944 */       _size_ += CodedOutputStream.computeInt32Size(3, this.itemtype);
/*  945 */       _size_ += CodedOutputStream.computeBoolSize(4, this.taskstate);
/*  946 */       _size_ += CodedOutputStream.computeBoolSize(5, this.ganghelpstate);
/*  947 */       _size_ += CodedOutputStream.computeBoolSize(6, this.friendhelpstate);
/*  948 */       _size_ += CodedOutputStream.computeInt64Size(7, this.roleid);
/*  949 */       _size_ += CodedOutputStream.computeInt32Size(8, this.xiulianexp);
/*  950 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  958 */         _output_.writeInt32(1, this.itemcfgid);
/*  959 */         _output_.writeInt32(2, this.itemnum);
/*  960 */         _output_.writeInt32(3, this.itemtype);
/*  961 */         _output_.writeBool(4, this.taskstate);
/*  962 */         _output_.writeBool(5, this.ganghelpstate);
/*  963 */         _output_.writeBool(6, this.friendhelpstate);
/*  964 */         _output_.writeInt64(7, this.roleid);
/*  965 */         _output_.writeInt32(8, this.xiulianexp);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  969 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  971 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  979 */         boolean done = false;
/*  980 */         while (!done)
/*      */         {
/*  982 */           int tag = _input_.readTag();
/*  983 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  987 */             done = true;
/*  988 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  992 */             this.itemcfgid = _input_.readInt32();
/*  993 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  997 */             this.itemnum = _input_.readInt32();
/*  998 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1002 */             this.itemtype = _input_.readInt32();
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1007 */             this.taskstate = _input_.readBool();
/* 1008 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1012 */             this.ganghelpstate = _input_.readBool();
/* 1013 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1017 */             this.friendhelpstate = _input_.readBool();
/* 1018 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1022 */             this.roleid = _input_.readInt64();
/* 1023 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1027 */             this.xiulianexp = _input_.readInt32();
/* 1028 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1032 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1034 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1043 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1047 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1049 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ItemInfo copy()
/*      */     {
/* 1055 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ItemInfo toData()
/*      */     {
/* 1061 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ItemInfo toBean()
/*      */     {
/* 1066 */       return new ItemInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ItemInfo toDataIf()
/*      */     {
/* 1072 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ItemInfo toBeanIf()
/*      */     {
/* 1077 */       return new ItemInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1083 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1087 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1091 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1095 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1099 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1103 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1107 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemcfgid()
/*      */     {
/* 1114 */       return this.itemcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemnum()
/*      */     {
/* 1121 */       return this.itemnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemtype()
/*      */     {
/* 1128 */       return this.itemtype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getTaskstate()
/*      */     {
/* 1135 */       return this.taskstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGanghelpstate()
/*      */     {
/* 1142 */       return this.ganghelpstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getFriendhelpstate()
/*      */     {
/* 1149 */       return this.friendhelpstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1156 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getXiulianexp()
/*      */     {
/* 1163 */       return this.xiulianexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemcfgid(int _v_)
/*      */     {
/* 1170 */       this.itemcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemnum(int _v_)
/*      */     {
/* 1177 */       this.itemnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemtype(int _v_)
/*      */     {
/* 1184 */       this.itemtype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTaskstate(boolean _v_)
/*      */     {
/* 1191 */       this.taskstate = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGanghelpstate(boolean _v_)
/*      */     {
/* 1198 */       this.ganghelpstate = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFriendhelpstate(boolean _v_)
/*      */     {
/* 1205 */       this.friendhelpstate = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1212 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setXiulianexp(int _v_)
/*      */     {
/* 1219 */       this.xiulianexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1225 */       if (!(_o1_ instanceof Data)) return false;
/* 1226 */       Data _o_ = (Data)_o1_;
/* 1227 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/* 1228 */       if (this.itemnum != _o_.itemnum) return false;
/* 1229 */       if (this.itemtype != _o_.itemtype) return false;
/* 1230 */       if (this.taskstate != _o_.taskstate) return false;
/* 1231 */       if (this.ganghelpstate != _o_.ganghelpstate) return false;
/* 1232 */       if (this.friendhelpstate != _o_.friendhelpstate) return false;
/* 1233 */       if (this.roleid != _o_.roleid) return false;
/* 1234 */       if (this.xiulianexp != _o_.xiulianexp) return false;
/* 1235 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1241 */       int _h_ = 0;
/* 1242 */       _h_ += this.itemcfgid;
/* 1243 */       _h_ += this.itemnum;
/* 1244 */       _h_ += this.itemtype;
/* 1245 */       _h_ += (this.taskstate ? 1231 : 1237);
/* 1246 */       _h_ += (this.ganghelpstate ? 1231 : 1237);
/* 1247 */       _h_ += (this.friendhelpstate ? 1231 : 1237);
/* 1248 */       _h_ = (int)(_h_ + this.roleid);
/* 1249 */       _h_ += this.xiulianexp;
/* 1250 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1256 */       StringBuilder _sb_ = new StringBuilder();
/* 1257 */       _sb_.append("(");
/* 1258 */       _sb_.append(this.itemcfgid);
/* 1259 */       _sb_.append(",");
/* 1260 */       _sb_.append(this.itemnum);
/* 1261 */       _sb_.append(",");
/* 1262 */       _sb_.append(this.itemtype);
/* 1263 */       _sb_.append(",");
/* 1264 */       _sb_.append(this.taskstate);
/* 1265 */       _sb_.append(",");
/* 1266 */       _sb_.append(this.ganghelpstate);
/* 1267 */       _sb_.append(",");
/* 1268 */       _sb_.append(this.friendhelpstate);
/* 1269 */       _sb_.append(",");
/* 1270 */       _sb_.append(this.roleid);
/* 1271 */       _sb_.append(",");
/* 1272 */       _sb_.append(this.xiulianexp);
/* 1273 */       _sb_.append(")");
/* 1274 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */