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
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class MarketItem extends XBean implements xbean.MarketItem
/*      */ {
/*      */   private int rest_num;
/*      */   private xbean.Item item;
/*      */   private long roleid;
/*      */   private int price;
/*      */   private int state;
/*      */   private long onshelf_time;
/*      */   private int concern_role_num;
/*      */   private long channel_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.rest_num = 0;
/*   33 */     this.item._reset_unsafe_();
/*   34 */     this.roleid = 0L;
/*   35 */     this.price = 0;
/*   36 */     this.state = 0;
/*   37 */     this.onshelf_time = 0L;
/*   38 */     this.concern_role_num = 0;
/*   39 */     this.channel_id = 0L;
/*      */   }
/*      */   
/*      */   MarketItem(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.item = new Item(0, this, "item");
/*      */   }
/*      */   
/*      */   public MarketItem()
/*      */   {
/*   50 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MarketItem(MarketItem _o_)
/*      */   {
/*   55 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MarketItem(xbean.MarketItem _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   60 */     super(_xp_, _vn_);
/*   61 */     if ((_o1_ instanceof MarketItem)) { assign((MarketItem)_o1_);
/*   62 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   63 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   64 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MarketItem _o_) {
/*   69 */     _o_._xdb_verify_unsafe_();
/*   70 */     this.rest_num = _o_.rest_num;
/*   71 */     this.item = new Item(_o_.item, this, "item");
/*   72 */     this.roleid = _o_.roleid;
/*   73 */     this.price = _o_.price;
/*   74 */     this.state = _o_.state;
/*   75 */     this.onshelf_time = _o_.onshelf_time;
/*   76 */     this.concern_role_num = _o_.concern_role_num;
/*   77 */     this.channel_id = _o_.channel_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   82 */     this.rest_num = _o_.rest_num;
/*   83 */     this.item = new Item(_o_.item, this, "item");
/*   84 */     this.roleid = _o_.roleid;
/*   85 */     this.price = _o_.price;
/*   86 */     this.state = _o_.state;
/*   87 */     this.onshelf_time = _o_.onshelf_time;
/*   88 */     this.concern_role_num = _o_.concern_role_num;
/*   89 */     this.channel_id = _o_.channel_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   95 */     _xdb_verify_unsafe_();
/*   96 */     _os_.marshal(this.rest_num);
/*   97 */     this.item.marshal(_os_);
/*   98 */     _os_.marshal(this.roleid);
/*   99 */     _os_.marshal(this.price);
/*  100 */     _os_.marshal(this.state);
/*  101 */     _os_.marshal(this.onshelf_time);
/*  102 */     _os_.marshal(this.concern_role_num);
/*  103 */     _os_.marshal(this.channel_id);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     this.rest_num = _os_.unmarshal_int();
/*  112 */     this.item.unmarshal(_os_);
/*  113 */     this.roleid = _os_.unmarshal_long();
/*  114 */     this.price = _os_.unmarshal_int();
/*  115 */     this.state = _os_.unmarshal_int();
/*  116 */     this.onshelf_time = _os_.unmarshal_long();
/*  117 */     this.concern_role_num = _os_.unmarshal_int();
/*  118 */     this.channel_id = _os_.unmarshal_long();
/*  119 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*  126 */     int _size_ = 0;
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(1, this.rest_num);
/*  128 */     _size_ += CodedOutputStream.computeMessageSize(2, this.item);
/*  129 */     _size_ += CodedOutputStream.computeInt64Size(3, this.roleid);
/*  130 */     _size_ += CodedOutputStream.computeInt32Size(4, this.price);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(5, this.state);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(6, this.onshelf_time);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(7, this.concern_role_num);
/*  134 */     _size_ += CodedOutputStream.computeInt64Size(8, this.channel_id);
/*  135 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  144 */       _output_.writeInt32(1, this.rest_num);
/*  145 */       _output_.writeMessage(2, this.item);
/*  146 */       _output_.writeInt64(3, this.roleid);
/*  147 */       _output_.writeInt32(4, this.price);
/*  148 */       _output_.writeInt32(5, this.state);
/*  149 */       _output_.writeInt64(6, this.onshelf_time);
/*  150 */       _output_.writeInt32(7, this.concern_role_num);
/*  151 */       _output_.writeInt64(8, this.channel_id);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  157 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  163 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  166 */       boolean done = false;
/*  167 */       while (!done)
/*      */       {
/*  169 */         int tag = _input_.readTag();
/*  170 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  174 */           done = true;
/*  175 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  179 */           this.rest_num = _input_.readInt32();
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  184 */           _input_.readMessage(this.item);
/*  185 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  189 */           this.roleid = _input_.readInt64();
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  194 */           this.price = _input_.readInt32();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  199 */           this.state = _input_.readInt32();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  204 */           this.onshelf_time = _input_.readInt64();
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  209 */           this.concern_role_num = _input_.readInt32();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  214 */           this.channel_id = _input_.readInt64();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  219 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  221 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  230 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  234 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  236 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketItem copy()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new MarketItem(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketItem toData()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarketItem toBean()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new MarketItem(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketItem toDataIf()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarketItem toBeanIf()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRest_num()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.rest_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.Item getItem()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.item;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPrice()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOnshelf_time()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.onshelf_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getConcern_role_num()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.concern_role_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getChannel_id()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.channel_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRest_num(int _v_)
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     Logs.logIf(new LogKey(this, "rest_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  352 */         new LogInt(this, MarketItem.this.rest_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  356 */             MarketItem.this.rest_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  360 */     });
/*  361 */     this.rest_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  373 */         new LogLong(this, MarketItem.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  377 */             MarketItem.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  381 */     });
/*  382 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPrice(int _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     Logs.logIf(new LogKey(this, "price")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  394 */         new LogInt(this, MarketItem.this.price)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             MarketItem.this.price = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.price = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  415 */         new LogInt(this, MarketItem.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             MarketItem.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOnshelf_time(long _v_)
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     Logs.logIf(new LogKey(this, "onshelf_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  436 */         new LogLong(this, MarketItem.this.onshelf_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  440 */             MarketItem.this.onshelf_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  444 */     });
/*  445 */     this.onshelf_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setConcern_role_num(int _v_)
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     Logs.logIf(new LogKey(this, "concern_role_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  457 */         new LogInt(this, MarketItem.this.concern_role_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  461 */             MarketItem.this.concern_role_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  465 */     });
/*  466 */     this.concern_role_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChannel_id(long _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     Logs.logIf(new LogKey(this, "channel_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  478 */         new LogLong(this, MarketItem.this.channel_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  482 */             MarketItem.this.channel_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  486 */     });
/*  487 */     this.channel_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     MarketItem _o_ = null;
/*  495 */     if ((_o1_ instanceof MarketItem)) { _o_ = (MarketItem)_o1_;
/*  496 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  497 */       return false;
/*  498 */     if (this.rest_num != _o_.rest_num) return false;
/*  499 */     if (!this.item.equals(_o_.item)) return false;
/*  500 */     if (this.roleid != _o_.roleid) return false;
/*  501 */     if (this.price != _o_.price) return false;
/*  502 */     if (this.state != _o_.state) return false;
/*  503 */     if (this.onshelf_time != _o_.onshelf_time) return false;
/*  504 */     if (this.concern_role_num != _o_.concern_role_num) return false;
/*  505 */     if (this.channel_id != _o_.channel_id) return false;
/*  506 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  512 */     _xdb_verify_unsafe_();
/*  513 */     int _h_ = 0;
/*  514 */     _h_ += this.rest_num;
/*  515 */     _h_ += this.item.hashCode();
/*  516 */     _h_ = (int)(_h_ + this.roleid);
/*  517 */     _h_ += this.price;
/*  518 */     _h_ += this.state;
/*  519 */     _h_ = (int)(_h_ + this.onshelf_time);
/*  520 */     _h_ += this.concern_role_num;
/*  521 */     _h_ = (int)(_h_ + this.channel_id);
/*  522 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*  529 */     StringBuilder _sb_ = new StringBuilder();
/*  530 */     _sb_.append("(");
/*  531 */     _sb_.append(this.rest_num);
/*  532 */     _sb_.append(",");
/*  533 */     _sb_.append(this.item);
/*  534 */     _sb_.append(",");
/*  535 */     _sb_.append(this.roleid);
/*  536 */     _sb_.append(",");
/*  537 */     _sb_.append(this.price);
/*  538 */     _sb_.append(",");
/*  539 */     _sb_.append(this.state);
/*  540 */     _sb_.append(",");
/*  541 */     _sb_.append(this.onshelf_time);
/*  542 */     _sb_.append(",");
/*  543 */     _sb_.append(this.concern_role_num);
/*  544 */     _sb_.append(",");
/*  545 */     _sb_.append(this.channel_id);
/*  546 */     _sb_.append(")");
/*  547 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  553 */     ListenableBean lb = new ListenableBean();
/*  554 */     lb.add(new ListenableChanged().setVarName("rest_num"));
/*  555 */     lb.add(new ListenableChanged().setVarName("item"));
/*  556 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  557 */     lb.add(new ListenableChanged().setVarName("price"));
/*  558 */     lb.add(new ListenableChanged().setVarName("state"));
/*  559 */     lb.add(new ListenableChanged().setVarName("onshelf_time"));
/*  560 */     lb.add(new ListenableChanged().setVarName("concern_role_num"));
/*  561 */     lb.add(new ListenableChanged().setVarName("channel_id"));
/*  562 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MarketItem {
/*      */     private Const() {}
/*      */     
/*      */     MarketItem nThis() {
/*  569 */       return MarketItem.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  575 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketItem copy()
/*      */     {
/*  581 */       return MarketItem.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketItem toData()
/*      */     {
/*  587 */       return MarketItem.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MarketItem toBean()
/*      */     {
/*  592 */       return MarketItem.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketItem toDataIf()
/*      */     {
/*  598 */       return MarketItem.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MarketItem toBeanIf()
/*      */     {
/*  603 */       return MarketItem.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRest_num()
/*      */     {
/*  610 */       MarketItem.this._xdb_verify_unsafe_();
/*  611 */       return MarketItem.this.rest_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Item getItem()
/*      */     {
/*  618 */       MarketItem.this._xdb_verify_unsafe_();
/*  619 */       return (xbean.Item)xdb.Consts.toConst(MarketItem.this.item);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  626 */       MarketItem.this._xdb_verify_unsafe_();
/*  627 */       return MarketItem.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/*  634 */       MarketItem.this._xdb_verify_unsafe_();
/*  635 */       return MarketItem.this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  642 */       MarketItem.this._xdb_verify_unsafe_();
/*  643 */       return MarketItem.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnshelf_time()
/*      */     {
/*  650 */       MarketItem.this._xdb_verify_unsafe_();
/*  651 */       return MarketItem.this.onshelf_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConcern_role_num()
/*      */     {
/*  658 */       MarketItem.this._xdb_verify_unsafe_();
/*  659 */       return MarketItem.this.concern_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChannel_id()
/*      */     {
/*  666 */       MarketItem.this._xdb_verify_unsafe_();
/*  667 */       return MarketItem.this.channel_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRest_num(int _v_)
/*      */     {
/*  674 */       MarketItem.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  682 */       MarketItem.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/*  690 */       MarketItem.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  698 */       MarketItem.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnshelf_time(long _v_)
/*      */     {
/*  706 */       MarketItem.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConcern_role_num(int _v_)
/*      */     {
/*  714 */       MarketItem.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannel_id(long _v_)
/*      */     {
/*  722 */       MarketItem.this._xdb_verify_unsafe_();
/*  723 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  729 */       MarketItem.this._xdb_verify_unsafe_();
/*  730 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  736 */       MarketItem.this._xdb_verify_unsafe_();
/*  737 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  743 */       return MarketItem.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  749 */       return MarketItem.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  755 */       MarketItem.this._xdb_verify_unsafe_();
/*  756 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  762 */       return MarketItem.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  768 */       return MarketItem.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  774 */       MarketItem.this._xdb_verify_unsafe_();
/*  775 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  781 */       return MarketItem.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  787 */       return MarketItem.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  793 */       return MarketItem.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  799 */       return MarketItem.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  805 */       return MarketItem.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  811 */       return MarketItem.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  817 */       return MarketItem.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MarketItem
/*      */   {
/*      */     private int rest_num;
/*      */     
/*      */     private xbean.Item item;
/*      */     
/*      */     private long roleid;
/*      */     
/*      */     private int price;
/*      */     
/*      */     private int state;
/*      */     
/*      */     private long onshelf_time;
/*      */     
/*      */     private int concern_role_num;
/*      */     
/*      */     private long channel_id;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  843 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  848 */       this.item = new Item.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.MarketItem _o1_)
/*      */     {
/*  853 */       if ((_o1_ instanceof MarketItem)) { assign((MarketItem)_o1_);
/*  854 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  855 */       } else if ((_o1_ instanceof MarketItem.Const)) assign(((MarketItem.Const)_o1_).nThis()); else {
/*  856 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MarketItem _o_) {
/*  861 */       this.rest_num = _o_.rest_num;
/*  862 */       this.item = new Item.Data(_o_.item);
/*  863 */       this.roleid = _o_.roleid;
/*  864 */       this.price = _o_.price;
/*  865 */       this.state = _o_.state;
/*  866 */       this.onshelf_time = _o_.onshelf_time;
/*  867 */       this.concern_role_num = _o_.concern_role_num;
/*  868 */       this.channel_id = _o_.channel_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  873 */       this.rest_num = _o_.rest_num;
/*  874 */       this.item = new Item.Data(_o_.item);
/*  875 */       this.roleid = _o_.roleid;
/*  876 */       this.price = _o_.price;
/*  877 */       this.state = _o_.state;
/*  878 */       this.onshelf_time = _o_.onshelf_time;
/*  879 */       this.concern_role_num = _o_.concern_role_num;
/*  880 */       this.channel_id = _o_.channel_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  886 */       _os_.marshal(this.rest_num);
/*  887 */       this.item.marshal(_os_);
/*  888 */       _os_.marshal(this.roleid);
/*  889 */       _os_.marshal(this.price);
/*  890 */       _os_.marshal(this.state);
/*  891 */       _os_.marshal(this.onshelf_time);
/*  892 */       _os_.marshal(this.concern_role_num);
/*  893 */       _os_.marshal(this.channel_id);
/*  894 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  900 */       this.rest_num = _os_.unmarshal_int();
/*  901 */       this.item.unmarshal(_os_);
/*  902 */       this.roleid = _os_.unmarshal_long();
/*  903 */       this.price = _os_.unmarshal_int();
/*  904 */       this.state = _os_.unmarshal_int();
/*  905 */       this.onshelf_time = _os_.unmarshal_long();
/*  906 */       this.concern_role_num = _os_.unmarshal_int();
/*  907 */       this.channel_id = _os_.unmarshal_long();
/*  908 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  914 */       int _size_ = 0;
/*  915 */       _size_ += CodedOutputStream.computeInt32Size(1, this.rest_num);
/*  916 */       _size_ += CodedOutputStream.computeMessageSize(2, this.item);
/*  917 */       _size_ += CodedOutputStream.computeInt64Size(3, this.roleid);
/*  918 */       _size_ += CodedOutputStream.computeInt32Size(4, this.price);
/*  919 */       _size_ += CodedOutputStream.computeInt32Size(5, this.state);
/*  920 */       _size_ += CodedOutputStream.computeInt64Size(6, this.onshelf_time);
/*  921 */       _size_ += CodedOutputStream.computeInt32Size(7, this.concern_role_num);
/*  922 */       _size_ += CodedOutputStream.computeInt64Size(8, this.channel_id);
/*  923 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  931 */         _output_.writeInt32(1, this.rest_num);
/*  932 */         _output_.writeMessage(2, this.item);
/*  933 */         _output_.writeInt64(3, this.roleid);
/*  934 */         _output_.writeInt32(4, this.price);
/*  935 */         _output_.writeInt32(5, this.state);
/*  936 */         _output_.writeInt64(6, this.onshelf_time);
/*  937 */         _output_.writeInt32(7, this.concern_role_num);
/*  938 */         _output_.writeInt64(8, this.channel_id);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  942 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  944 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  952 */         boolean done = false;
/*  953 */         while (!done)
/*      */         {
/*  955 */           int tag = _input_.readTag();
/*  956 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  960 */             done = true;
/*  961 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  965 */             this.rest_num = _input_.readInt32();
/*  966 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/*  970 */             _input_.readMessage(this.item);
/*  971 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  975 */             this.roleid = _input_.readInt64();
/*  976 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  980 */             this.price = _input_.readInt32();
/*  981 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  985 */             this.state = _input_.readInt32();
/*  986 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  990 */             this.onshelf_time = _input_.readInt64();
/*  991 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  995 */             this.concern_role_num = _input_.readInt32();
/*  996 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1000 */             this.channel_id = _input_.readInt64();
/* 1001 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1005 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1007 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1016 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1020 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1022 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketItem copy()
/*      */     {
/* 1028 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketItem toData()
/*      */     {
/* 1034 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MarketItem toBean()
/*      */     {
/* 1039 */       return new MarketItem(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketItem toDataIf()
/*      */     {
/* 1045 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MarketItem toBeanIf()
/*      */     {
/* 1050 */       return new MarketItem(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1056 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1060 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1064 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1068 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1072 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1076 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1080 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRest_num()
/*      */     {
/* 1087 */       return this.rest_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Item getItem()
/*      */     {
/* 1094 */       return this.item;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1101 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/* 1108 */       return this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1115 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnshelf_time()
/*      */     {
/* 1122 */       return this.onshelf_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConcern_role_num()
/*      */     {
/* 1129 */       return this.concern_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChannel_id()
/*      */     {
/* 1136 */       return this.channel_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRest_num(int _v_)
/*      */     {
/* 1143 */       this.rest_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1150 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/* 1157 */       this.price = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1164 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnshelf_time(long _v_)
/*      */     {
/* 1171 */       this.onshelf_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConcern_role_num(int _v_)
/*      */     {
/* 1178 */       this.concern_role_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannel_id(long _v_)
/*      */     {
/* 1185 */       this.channel_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1191 */       if (!(_o1_ instanceof Data)) return false;
/* 1192 */       Data _o_ = (Data)_o1_;
/* 1193 */       if (this.rest_num != _o_.rest_num) return false;
/* 1194 */       if (!this.item.equals(_o_.item)) return false;
/* 1195 */       if (this.roleid != _o_.roleid) return false;
/* 1196 */       if (this.price != _o_.price) return false;
/* 1197 */       if (this.state != _o_.state) return false;
/* 1198 */       if (this.onshelf_time != _o_.onshelf_time) return false;
/* 1199 */       if (this.concern_role_num != _o_.concern_role_num) return false;
/* 1200 */       if (this.channel_id != _o_.channel_id) return false;
/* 1201 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1207 */       int _h_ = 0;
/* 1208 */       _h_ += this.rest_num;
/* 1209 */       _h_ += this.item.hashCode();
/* 1210 */       _h_ = (int)(_h_ + this.roleid);
/* 1211 */       _h_ += this.price;
/* 1212 */       _h_ += this.state;
/* 1213 */       _h_ = (int)(_h_ + this.onshelf_time);
/* 1214 */       _h_ += this.concern_role_num;
/* 1215 */       _h_ = (int)(_h_ + this.channel_id);
/* 1216 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1222 */       StringBuilder _sb_ = new StringBuilder();
/* 1223 */       _sb_.append("(");
/* 1224 */       _sb_.append(this.rest_num);
/* 1225 */       _sb_.append(",");
/* 1226 */       _sb_.append(this.item);
/* 1227 */       _sb_.append(",");
/* 1228 */       _sb_.append(this.roleid);
/* 1229 */       _sb_.append(",");
/* 1230 */       _sb_.append(this.price);
/* 1231 */       _sb_.append(",");
/* 1232 */       _sb_.append(this.state);
/* 1233 */       _sb_.append(",");
/* 1234 */       _sb_.append(this.onshelf_time);
/* 1235 */       _sb_.append(",");
/* 1236 */       _sb_.append(this.concern_role_num);
/* 1237 */       _sb_.append(",");
/* 1238 */       _sb_.append(this.channel_id);
/* 1239 */       _sb_.append(")");
/* 1240 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */