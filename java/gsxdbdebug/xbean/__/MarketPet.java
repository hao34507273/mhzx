/*      */ package xbean.__;
/*      */ 
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
/*      */ public final class MarketPet extends XBean implements xbean.MarketPet
/*      */ {
/*      */   private xbean.Pet pet;
/*      */   private long roleid;
/*      */   private int price;
/*      */   private int state;
/*      */   private long onshelf_time;
/*      */   private int concern_role_num;
/*      */   private long channel_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.pet._reset_unsafe_();
/*   31 */     this.roleid = 0L;
/*   32 */     this.price = 0;
/*   33 */     this.state = 0;
/*   34 */     this.onshelf_time = 0L;
/*   35 */     this.concern_role_num = 0;
/*   36 */     this.channel_id = 0L;
/*      */   }
/*      */   
/*      */   MarketPet(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.pet = new Pet(0, this, "pet");
/*      */   }
/*      */   
/*      */   public MarketPet()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MarketPet(MarketPet _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MarketPet(xbean.MarketPet _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof MarketPet)) { assign((MarketPet)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MarketPet _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.pet = new Pet(_o_.pet, this, "pet");
/*   68 */     this.roleid = _o_.roleid;
/*   69 */     this.price = _o_.price;
/*   70 */     this.state = _o_.state;
/*   71 */     this.onshelf_time = _o_.onshelf_time;
/*   72 */     this.concern_role_num = _o_.concern_role_num;
/*   73 */     this.channel_id = _o_.channel_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.pet = new Pet(_o_.pet, this, "pet");
/*   79 */     this.roleid = _o_.roleid;
/*   80 */     this.price = _o_.price;
/*   81 */     this.state = _o_.state;
/*   82 */     this.onshelf_time = _o_.onshelf_time;
/*   83 */     this.concern_role_num = _o_.concern_role_num;
/*   84 */     this.channel_id = _o_.channel_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     this.pet.marshal(_os_);
/*   92 */     _os_.marshal(this.roleid);
/*   93 */     _os_.marshal(this.price);
/*   94 */     _os_.marshal(this.state);
/*   95 */     _os_.marshal(this.onshelf_time);
/*   96 */     _os_.marshal(this.concern_role_num);
/*   97 */     _os_.marshal(this.channel_id);
/*   98 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     this.pet.unmarshal(_os_);
/*  106 */     this.roleid = _os_.unmarshal_long();
/*  107 */     this.price = _os_.unmarshal_int();
/*  108 */     this.state = _os_.unmarshal_int();
/*  109 */     this.onshelf_time = _os_.unmarshal_long();
/*  110 */     this.concern_role_num = _os_.unmarshal_int();
/*  111 */     this.channel_id = _os_.unmarshal_long();
/*  112 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     int _size_ = 0;
/*  120 */     _size_ += CodedOutputStream.computeMessageSize(1, this.pet);
/*  121 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(3, this.price);
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(4, this.state);
/*  124 */     _size_ += CodedOutputStream.computeInt64Size(5, this.onshelf_time);
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(6, this.concern_role_num);
/*  126 */     _size_ += CodedOutputStream.computeInt64Size(7, this.channel_id);
/*  127 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  136 */       _output_.writeMessage(1, this.pet);
/*  137 */       _output_.writeInt64(2, this.roleid);
/*  138 */       _output_.writeInt32(3, this.price);
/*  139 */       _output_.writeInt32(4, this.state);
/*  140 */       _output_.writeInt64(5, this.onshelf_time);
/*  141 */       _output_.writeInt32(6, this.concern_role_num);
/*  142 */       _output_.writeInt64(7, this.channel_id);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  146 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  148 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  154 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  157 */       boolean done = false;
/*  158 */       while (!done)
/*      */       {
/*  160 */         int tag = _input_.readTag();
/*  161 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  165 */           done = true;
/*  166 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  170 */           _input_.readMessage(this.pet);
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  175 */           this.roleid = _input_.readInt64();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  180 */           this.price = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  185 */           this.state = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  190 */           this.onshelf_time = _input_.readInt64();
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  195 */           this.concern_role_num = _input_.readInt32();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  200 */           this.channel_id = _input_.readInt64();
/*  201 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  205 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  207 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  216 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  220 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  222 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketPet copy()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     return new MarketPet(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketPet toData()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarketPet toBean()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new MarketPet(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MarketPet toDataIf()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MarketPet toBeanIf()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.Pet getPet()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return this.pet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPrice()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOnshelf_time()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return this.onshelf_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getConcern_role_num()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return this.concern_role_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getChannel_id()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return this.channel_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  325 */     _xdb_verify_unsafe_();
/*  326 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  330 */         new LogLong(this, MarketPet.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  334 */             MarketPet.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  338 */     });
/*  339 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPrice(int _v_)
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     Logs.logIf(new LogKey(this, "price")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  351 */         new LogInt(this, MarketPet.this.price)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  355 */             MarketPet.this.price = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  359 */     });
/*  360 */     this.price = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  372 */         new LogInt(this, MarketPet.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             MarketPet.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOnshelf_time(long _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     Logs.logIf(new LogKey(this, "onshelf_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  393 */         new LogLong(this, MarketPet.this.onshelf_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             MarketPet.this.onshelf_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.onshelf_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setConcern_role_num(int _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     Logs.logIf(new LogKey(this, "concern_role_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  414 */         new LogInt(this, MarketPet.this.concern_role_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             MarketPet.this.concern_role_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.concern_role_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChannel_id(long _v_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     Logs.logIf(new LogKey(this, "channel_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  435 */         new LogLong(this, MarketPet.this.channel_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  439 */             MarketPet.this.channel_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  443 */     });
/*  444 */     this.channel_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     MarketPet _o_ = null;
/*  452 */     if ((_o1_ instanceof MarketPet)) { _o_ = (MarketPet)_o1_;
/*  453 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  454 */       return false;
/*  455 */     if (!this.pet.equals(_o_.pet)) return false;
/*  456 */     if (this.roleid != _o_.roleid) return false;
/*  457 */     if (this.price != _o_.price) return false;
/*  458 */     if (this.state != _o_.state) return false;
/*  459 */     if (this.onshelf_time != _o_.onshelf_time) return false;
/*  460 */     if (this.concern_role_num != _o_.concern_role_num) return false;
/*  461 */     if (this.channel_id != _o_.channel_id) return false;
/*  462 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  468 */     _xdb_verify_unsafe_();
/*  469 */     int _h_ = 0;
/*  470 */     _h_ += this.pet.hashCode();
/*  471 */     _h_ = (int)(_h_ + this.roleid);
/*  472 */     _h_ += this.price;
/*  473 */     _h_ += this.state;
/*  474 */     _h_ = (int)(_h_ + this.onshelf_time);
/*  475 */     _h_ += this.concern_role_num;
/*  476 */     _h_ = (int)(_h_ + this.channel_id);
/*  477 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     StringBuilder _sb_ = new StringBuilder();
/*  485 */     _sb_.append("(");
/*  486 */     _sb_.append(this.pet);
/*  487 */     _sb_.append(",");
/*  488 */     _sb_.append(this.roleid);
/*  489 */     _sb_.append(",");
/*  490 */     _sb_.append(this.price);
/*  491 */     _sb_.append(",");
/*  492 */     _sb_.append(this.state);
/*  493 */     _sb_.append(",");
/*  494 */     _sb_.append(this.onshelf_time);
/*  495 */     _sb_.append(",");
/*  496 */     _sb_.append(this.concern_role_num);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.channel_id);
/*  499 */     _sb_.append(")");
/*  500 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  506 */     ListenableBean lb = new ListenableBean();
/*  507 */     lb.add(new ListenableChanged().setVarName("pet"));
/*  508 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  509 */     lb.add(new ListenableChanged().setVarName("price"));
/*  510 */     lb.add(new ListenableChanged().setVarName("state"));
/*  511 */     lb.add(new ListenableChanged().setVarName("onshelf_time"));
/*  512 */     lb.add(new ListenableChanged().setVarName("concern_role_num"));
/*  513 */     lb.add(new ListenableChanged().setVarName("channel_id"));
/*  514 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MarketPet {
/*      */     private Const() {}
/*      */     
/*      */     MarketPet nThis() {
/*  521 */       return MarketPet.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  527 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPet copy()
/*      */     {
/*  533 */       return MarketPet.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPet toData()
/*      */     {
/*  539 */       return MarketPet.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MarketPet toBean()
/*      */     {
/*  544 */       return MarketPet.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPet toDataIf()
/*      */     {
/*  550 */       return MarketPet.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MarketPet toBeanIf()
/*      */     {
/*  555 */       return MarketPet.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Pet getPet()
/*      */     {
/*  562 */       MarketPet.this._xdb_verify_unsafe_();
/*  563 */       return (xbean.Pet)xdb.Consts.toConst(MarketPet.this.pet);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  570 */       MarketPet.this._xdb_verify_unsafe_();
/*  571 */       return MarketPet.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/*  578 */       MarketPet.this._xdb_verify_unsafe_();
/*  579 */       return MarketPet.this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  586 */       MarketPet.this._xdb_verify_unsafe_();
/*  587 */       return MarketPet.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnshelf_time()
/*      */     {
/*  594 */       MarketPet.this._xdb_verify_unsafe_();
/*  595 */       return MarketPet.this.onshelf_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConcern_role_num()
/*      */     {
/*  602 */       MarketPet.this._xdb_verify_unsafe_();
/*  603 */       return MarketPet.this.concern_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChannel_id()
/*      */     {
/*  610 */       MarketPet.this._xdb_verify_unsafe_();
/*  611 */       return MarketPet.this.channel_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  618 */       MarketPet.this._xdb_verify_unsafe_();
/*  619 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/*  626 */       MarketPet.this._xdb_verify_unsafe_();
/*  627 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  634 */       MarketPet.this._xdb_verify_unsafe_();
/*  635 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnshelf_time(long _v_)
/*      */     {
/*  642 */       MarketPet.this._xdb_verify_unsafe_();
/*  643 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConcern_role_num(int _v_)
/*      */     {
/*  650 */       MarketPet.this._xdb_verify_unsafe_();
/*  651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannel_id(long _v_)
/*      */     {
/*  658 */       MarketPet.this._xdb_verify_unsafe_();
/*  659 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  665 */       MarketPet.this._xdb_verify_unsafe_();
/*  666 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  672 */       MarketPet.this._xdb_verify_unsafe_();
/*  673 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  679 */       return MarketPet.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  685 */       return MarketPet.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  691 */       MarketPet.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  698 */       return MarketPet.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  704 */       return MarketPet.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  710 */       MarketPet.this._xdb_verify_unsafe_();
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  717 */       return MarketPet.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  723 */       return MarketPet.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  729 */       return MarketPet.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  735 */       return MarketPet.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  741 */       return MarketPet.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  747 */       return MarketPet.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  753 */       return MarketPet.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MarketPet
/*      */   {
/*      */     private xbean.Pet pet;
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
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  782 */       this.pet = new Pet.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.MarketPet _o1_)
/*      */     {
/*  787 */       if ((_o1_ instanceof MarketPet)) { assign((MarketPet)_o1_);
/*  788 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  789 */       } else if ((_o1_ instanceof MarketPet.Const)) assign(((MarketPet.Const)_o1_).nThis()); else {
/*  790 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MarketPet _o_) {
/*  795 */       this.pet = new Pet.Data(_o_.pet);
/*  796 */       this.roleid = _o_.roleid;
/*  797 */       this.price = _o_.price;
/*  798 */       this.state = _o_.state;
/*  799 */       this.onshelf_time = _o_.onshelf_time;
/*  800 */       this.concern_role_num = _o_.concern_role_num;
/*  801 */       this.channel_id = _o_.channel_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  806 */       this.pet = new Pet.Data(_o_.pet);
/*  807 */       this.roleid = _o_.roleid;
/*  808 */       this.price = _o_.price;
/*  809 */       this.state = _o_.state;
/*  810 */       this.onshelf_time = _o_.onshelf_time;
/*  811 */       this.concern_role_num = _o_.concern_role_num;
/*  812 */       this.channel_id = _o_.channel_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  818 */       this.pet.marshal(_os_);
/*  819 */       _os_.marshal(this.roleid);
/*  820 */       _os_.marshal(this.price);
/*  821 */       _os_.marshal(this.state);
/*  822 */       _os_.marshal(this.onshelf_time);
/*  823 */       _os_.marshal(this.concern_role_num);
/*  824 */       _os_.marshal(this.channel_id);
/*  825 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  831 */       this.pet.unmarshal(_os_);
/*  832 */       this.roleid = _os_.unmarshal_long();
/*  833 */       this.price = _os_.unmarshal_int();
/*  834 */       this.state = _os_.unmarshal_int();
/*  835 */       this.onshelf_time = _os_.unmarshal_long();
/*  836 */       this.concern_role_num = _os_.unmarshal_int();
/*  837 */       this.channel_id = _os_.unmarshal_long();
/*  838 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  844 */       int _size_ = 0;
/*  845 */       _size_ += CodedOutputStream.computeMessageSize(1, this.pet);
/*  846 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/*  847 */       _size_ += CodedOutputStream.computeInt32Size(3, this.price);
/*  848 */       _size_ += CodedOutputStream.computeInt32Size(4, this.state);
/*  849 */       _size_ += CodedOutputStream.computeInt64Size(5, this.onshelf_time);
/*  850 */       _size_ += CodedOutputStream.computeInt32Size(6, this.concern_role_num);
/*  851 */       _size_ += CodedOutputStream.computeInt64Size(7, this.channel_id);
/*  852 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  860 */         _output_.writeMessage(1, this.pet);
/*  861 */         _output_.writeInt64(2, this.roleid);
/*  862 */         _output_.writeInt32(3, this.price);
/*  863 */         _output_.writeInt32(4, this.state);
/*  864 */         _output_.writeInt64(5, this.onshelf_time);
/*  865 */         _output_.writeInt32(6, this.concern_role_num);
/*  866 */         _output_.writeInt64(7, this.channel_id);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  870 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  872 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  880 */         boolean done = false;
/*  881 */         while (!done)
/*      */         {
/*  883 */           int tag = _input_.readTag();
/*  884 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  888 */             done = true;
/*  889 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  893 */             _input_.readMessage(this.pet);
/*  894 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  898 */             this.roleid = _input_.readInt64();
/*  899 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  903 */             this.price = _input_.readInt32();
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  908 */             this.state = _input_.readInt32();
/*  909 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  913 */             this.onshelf_time = _input_.readInt64();
/*  914 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  918 */             this.concern_role_num = _input_.readInt32();
/*  919 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  923 */             this.channel_id = _input_.readInt64();
/*  924 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  928 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  930 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  939 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  943 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  945 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPet copy()
/*      */     {
/*  951 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPet toData()
/*      */     {
/*  957 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MarketPet toBean()
/*      */     {
/*  962 */       return new MarketPet(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MarketPet toDataIf()
/*      */     {
/*  968 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MarketPet toBeanIf()
/*      */     {
/*  973 */       return new MarketPet(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  979 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  983 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  987 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  991 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  995 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  999 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1003 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.Pet getPet()
/*      */     {
/* 1010 */       return this.pet;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1017 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/* 1024 */       return this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1031 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOnshelf_time()
/*      */     {
/* 1038 */       return this.onshelf_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getConcern_role_num()
/*      */     {
/* 1045 */       return this.concern_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChannel_id()
/*      */     {
/* 1052 */       return this.channel_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1059 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/* 1066 */       this.price = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1073 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOnshelf_time(long _v_)
/*      */     {
/* 1080 */       this.onshelf_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConcern_role_num(int _v_)
/*      */     {
/* 1087 */       this.concern_role_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChannel_id(long _v_)
/*      */     {
/* 1094 */       this.channel_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1100 */       if (!(_o1_ instanceof Data)) return false;
/* 1101 */       Data _o_ = (Data)_o1_;
/* 1102 */       if (!this.pet.equals(_o_.pet)) return false;
/* 1103 */       if (this.roleid != _o_.roleid) return false;
/* 1104 */       if (this.price != _o_.price) return false;
/* 1105 */       if (this.state != _o_.state) return false;
/* 1106 */       if (this.onshelf_time != _o_.onshelf_time) return false;
/* 1107 */       if (this.concern_role_num != _o_.concern_role_num) return false;
/* 1108 */       if (this.channel_id != _o_.channel_id) return false;
/* 1109 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1115 */       int _h_ = 0;
/* 1116 */       _h_ += this.pet.hashCode();
/* 1117 */       _h_ = (int)(_h_ + this.roleid);
/* 1118 */       _h_ += this.price;
/* 1119 */       _h_ += this.state;
/* 1120 */       _h_ = (int)(_h_ + this.onshelf_time);
/* 1121 */       _h_ += this.concern_role_num;
/* 1122 */       _h_ = (int)(_h_ + this.channel_id);
/* 1123 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1129 */       StringBuilder _sb_ = new StringBuilder();
/* 1130 */       _sb_.append("(");
/* 1131 */       _sb_.append(this.pet);
/* 1132 */       _sb_.append(",");
/* 1133 */       _sb_.append(this.roleid);
/* 1134 */       _sb_.append(",");
/* 1135 */       _sb_.append(this.price);
/* 1136 */       _sb_.append(",");
/* 1137 */       _sb_.append(this.state);
/* 1138 */       _sb_.append(",");
/* 1139 */       _sb_.append(this.onshelf_time);
/* 1140 */       _sb_.append(",");
/* 1141 */       _sb_.append(this.concern_role_num);
/* 1142 */       _sb_.append(",");
/* 1143 */       _sb_.append(this.channel_id);
/* 1144 */       _sb_.append(")");
/* 1145 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */